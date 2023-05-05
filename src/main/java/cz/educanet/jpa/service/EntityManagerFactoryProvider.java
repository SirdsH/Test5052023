package cz.educanet.jpa.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@RequestScoped
@Named
public class EntityManagerFactoryProvider {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyUserApp");

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
