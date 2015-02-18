package dao;

import entity.StudGroup;

/**
 * Created by admin on 2/17/2015.
 */
public interface GroupDAO {
    public StudGroup find(long id);
    public void add(StudGroup studGroup);
    public  void update(StudGroup studGroup);
    public void delete(long id);
}
