package dao;

import entity.Person;

public interface PersonDAO {
    public Person getById(long id);
    public void add(Person person);
    public Person getAll();
    public void delete(long id);
    public void update(Person person);
}
