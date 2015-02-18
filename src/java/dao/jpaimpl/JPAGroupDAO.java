package dao.jpaimpl;

import dao.GroupDAO;
import dao.JPA;
import entity.StudGroup;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@JPA
public class JPAGroupDAO implements GroupDAO{
    @Inject
    private EntityManager entityManager;
    @Override
    public StudGroup find(long id) {
        return entityManager.find(StudGroup.class,id);
    }

    @Override
    public void add(StudGroup studGroup) {
        entityManager.merge(studGroup);
    }

    @Override
    public void update(StudGroup studGroup) {
        entityManager.merge(studGroup);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(StudGroup.class,id));
    }
}
