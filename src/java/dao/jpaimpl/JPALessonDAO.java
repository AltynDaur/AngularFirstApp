package dao.jpaimpl;

import dao.LessonDAO;
import dao.JPA;
import entity.Lesson;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@JPA
public class JPALessonDAO implements LessonDAO {
    @Inject
    private EntityManager entityManager;

    @Override
    public Lesson find(long id) {
        return entityManager.find(Lesson.class,id);
    }

    @Override
    @Transactional
    public void add(Lesson someLesson) {
        entityManager.merge(someLesson);
    }

    @Override
    public void update(Lesson someLesson) {
        entityManager.merge(someLesson);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Lesson.class,id));
    }

    @Override
    public List<Lesson> findByGroup(String groupName) {
        return null;
    }
}
