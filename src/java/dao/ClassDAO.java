package dao;

import entity.Class;

import java.util.List;

/**
 * Created by admin on 2/18/2015.
 */
public interface ClassDAO {
    public Class find(long id);
    public void add(Class someClass);
    public  void update(Class someClass);
    public void delete(long id);

    List<Class> findByGroup(String groupName);
}
