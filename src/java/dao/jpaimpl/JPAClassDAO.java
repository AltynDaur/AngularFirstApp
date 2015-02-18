package dao.jpaimpl;

import dao.ClassDAO;
import dao.JPA;
import entity.*;
import entity.Class;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@JPA
public class JPAClassDAO implements ClassDAO{
    @Inject
    private EntityManager entityManager;

    @Override
    public Class find(long id) {
        return entityManager.find(Class.class,id);
    }

    @Override
    public void add(Class someClass) {
        entityManager.merge(someClass);
    }

    @Override
    public void update(Class someClass) {
        entityManager.merge(someClass);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Class.class,id));
    }
}
