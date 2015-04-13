package dao;

import entity.Person;

import java.util.List;

public interface PersonDAO {
    public Person getById(int id);
    public Person add(Person person);
    public List<Person> getAll();
    public void delete(int id);
    public void update(Person person);

    public List<Person> getAllById(Integer id);
}
