package dao;

import entity.Chair;

/**
 * Created by admin on 2/17/2015.
 */
public interface ChairDAO {
    public Chair find(long id);
    public void add(Chair chair);
    public  void update(Chair chair);
    public void delete(long id);
}
