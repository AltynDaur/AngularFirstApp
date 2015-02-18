package dao.jpaimpl;

import dao.ChairDAO;
import dao.JPA;
import entity.Chair;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@JPA
public class JPAChairDAO implements ChairDAO{
    @Inject
    private EntityManager entityManager;
    @Override
    public Chair find(long id) {
        return entityManager.find(Chair.class,id);
    }

    @Override
    public void add(Chair chair) {
        entityManager.merge(chair);
    }

    @Override
    public void update(Chair chair) {
        entityManager.merge(chair);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Chair.class,id));
    }
}
