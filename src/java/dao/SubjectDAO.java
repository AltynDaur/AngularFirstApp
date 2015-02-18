package dao;

import entity.Subject;

/**
 * Created by admin on 2/17/2015.
 */
public interface SubjectDAO {
    public Subject find(long id);
    public void add(Subject subject);
    public  void update(Subject subject);
    public void delete(long id);
}
