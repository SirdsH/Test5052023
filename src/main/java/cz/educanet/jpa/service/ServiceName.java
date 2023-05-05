package cz.educanet.jpa.service;

import cz.educanet.jpa.entities.EntityName;
import cz.educanet.jpa.repository.RepositoryName;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named
public class ServiceName {
    @Inject
    private RepositoryName repositoryName;

    private EntityName entityName = new EntityName();

    public void createTask() {
        repositoryName.createTask(entityName);
    }

    public List<EntityName> getAllTasks() {
        return repositoryName.getAllTasks();
    }

    public void deleteTask(Long id) {
        repositoryName.deleteTask(id);
    }

    public EntityName getEntityName() {
        return entityName;
    }

    public void updateTask(Long id, String firstName, String lastName, String date, double mark) {
        repositoryName.updateTask(id, firstName, lastName, date, mark);
    }
    public double getAvg() {
        return repositoryName.getAllTasks().stream().mapToDouble(EntityName::getMark).average().getAsDouble();
    }
}
