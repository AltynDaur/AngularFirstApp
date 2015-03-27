package dao;

import entity.Wish;

public interface WishDAO {
    public void add(Wish wish);
    public Wish getAll();
    public void delete(long id);
    public void update(Wish wish);
}
