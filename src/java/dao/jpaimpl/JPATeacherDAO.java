package dao.jpaimpl;

import dao.JPA;
import dao.TeacherDAO;
import entity.Teacher;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@JPA
public class JPATeacherDAO implements TeacherDAO {
    @Inject
    private EntityManager entityManager;
    @Override
    public Teacher find(long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public void add(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Teacher.class,id));
    }
}
