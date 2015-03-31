package dao.jpaimpl;

import dao.JPA;
import dao.PersonDAO;
import entity.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
@JPA
public class JPAPersonDAO implements PersonDAO {
    @Inject
    private EntityManager entityManager;

    @Override
    public Person getById(long id) {
        return entityManager.find(Person.class,id);
    }

    @Override
    public void add(Person person) {
        entityManager.merge(person);
    }

    @Override
    public Person getAll() {
        return null;
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Person.class,id));
    }

    @Override
    public void update(Person person) {
        entityManager.merge(person);
    }
}
