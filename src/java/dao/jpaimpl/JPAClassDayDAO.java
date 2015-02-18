package dao.jpaimpl;

import dao.ClassDayDAO;
import dao.JPA;
import entity.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@JPA
public class JPAClassDayDAO implements ClassDayDAO{
    @Inject
    private EntityManager entityManager;
    @Override
    public ClassDay find(long id) {
        return entityManager.find(ClassDay.class,id);
    }

    @Override
    public void add(ClassDay classDay) {
        entityManager.merge(classDay);
    }

    @Override
    public void update(ClassDay classDay) {
        entityManager.merge(classDay);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(ClassDay.class,id));
    }
}
