package cz.educanet.jpa.repository;

import cz.educanet.jpa.entities.EntityName;
import cz.educanet.jpa.service.EntityManagerFactoryProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class RepositoryName {
    @Inject
    private EntityManagerFactoryProvider emf;

    public void createTask(EntityName name) {
        EntityManager em = emf.getEmf().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(name);

        et.commit();
        System.out.println(name.getFirstName());
        System.out.println(name.getLastName());
        System.out.println(name.getMark());
    }

    public void deleteTask(Long id) {
        EntityManager em = emf.getEmf().createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createQuery("DELETE FROM EntityName AS e WHERE e.id = :id");
        query.setParameter("id", id);
        int updatedRows = query.executeUpdate();
        System.out.println(updatedRows);

        et.commit();

    }

    public void updateTask(Long id, String firstName, String lastName, String date, double mark) {
        EntityManager em = emf.getEmf().createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createQuery("UPDATE EntityName AS e SET firstName = :firstName, lastName = :lastName, date = :date, mark = :mark WHERE e.id = :id");
        query.setParameter("id", id);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("date", date);
        query.setParameter("mark", mark);
        query.executeUpdate();
        et.commit();
        em.close();
    }


    public List<EntityName> getAllTasks() {
        EntityManager em = emf.getEmf().createEntityManager();

        TypedQuery<EntityName> result = em.createQuery("select task from EntityName as task", EntityName.class);
        return result.getResultList();
    }
}
