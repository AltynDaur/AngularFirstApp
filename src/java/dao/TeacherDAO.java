package dao;

import entity.Teacher;

/**
 * Created by admin on 2/17/2015.
 */
public interface TeacherDAO {
    public Teacher find(long id);
    public void add(Teacher teacher);
    public  void update(Teacher teacher);
    public void delete(long id);
}
