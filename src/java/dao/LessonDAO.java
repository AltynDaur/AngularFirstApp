package dao;

import entity.Lesson;

import java.util.List;

/**
 * Created by admin on 2/18/2015.
 */
public interface LessonDAO {
    public Lesson find(long id);
    public void add(Lesson someLesson);
    public  void update(Lesson someLesson);
    public void delete(long id);

    List<Lesson> findByGroup(String groupName);
}
