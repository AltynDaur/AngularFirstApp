package dao.jpaimpl;

import dao.JPA;
import dao.PersonDAO;
import entity.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@JPA
public class JPAPersonDAO implements PersonDAO {
    @Inject
    private EntityManager entityManager;

    @Override
    public Person getById(int id) {
        return entityManager.find(Person.class,id);
    }

    @Override
    public Person add(Person person) {
        return entityManager.merge(person);
    }

    @Override
    public List<Person> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(Person.class);
        Root<Person> currentPerson = criteriaQuery.from(Person.class);
        criteriaQuery.select(currentPerson).orderBy(builder.asc(currentPerson.get("id")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Person.class,id));
    }

    @Override
    public void update(Person person) {
        entityManager.merge(person);
    }
}
