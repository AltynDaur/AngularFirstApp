package dao.jpaimpl;

import dao.JPA;
import dao.LoginPersonDAO;
import entity.LoginPerson;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@JPA
public class JPALoginPersonDAO implements LoginPersonDAO{

    @Inject
    private EntityManager entityManager;

    @Override
    public LoginPerson find(String login) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LoginPerson> criteriaQuery = cb.createQuery(LoginPerson.class);
        Root<LoginPerson> personRoot= criteriaQuery.from(LoginPerson.class);
        criteriaQuery.select(personRoot).where(cb.equal(personRoot.get("login"), login));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
