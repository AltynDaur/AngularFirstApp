package dao.jpaimpl;

import dao.JPA;
import dao.WishDAO;
import entity.Wish;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
@JPA
public class JPAWishDAO implements WishDAO{
    @Inject
    private EntityManager entityManager;

    @Override
    public Wish add(Wish wish) {
        return entityManager.merge(wish);

    }

    @Override
    public Wish getAll() {
        return null;
    }

    @Override
    public void delete(int id) {
        Wish wish = entityManager.find(Wish.class,id);
        entityManager.remove(wish);
    }

    @Override
    public void update(Wish wish) {
        entityManager.merge(wish);
    }

    @Override
    public Wish getById(int id) {
        return entityManager.find(Wish.class,id);
    }
}
