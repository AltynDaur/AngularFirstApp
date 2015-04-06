package dao;

import entity.Wish;

public interface WishDAO {
    public Wish add(Wish wish);
    public Wish getAll();
    public void delete(int id);
    public void update(Wish wish);

    public Wish getById(int id);
}
