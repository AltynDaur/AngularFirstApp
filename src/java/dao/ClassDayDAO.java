package dao;

import entity.ClassDay;

public interface ClassDayDAO {
    public ClassDay find(long id);
    public void add(ClassDay classDay);
    public  void update(ClassDay classDay);
    public void delete(long id);
}
