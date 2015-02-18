package dao.jpaimpl;

import dao.JPA;
import dao.SubjectDAO;
import entity.Subject;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@JPA
public class JPASubjectDAO implements SubjectDAO{
    @Inject
    private EntityManager entityManager;

    @Override
    public Subject find(long id) {
        return entityManager.find(Subject.class,id);
    }

    @Override
    public void add(Subject subject) {
        entityManager.merge(subject);
    }

    @Override
    public void update(Subject subject) {
        entityManager.merge(subject);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Subject.class,id));
    }
}
