package dao;

import entity.Room;

import java.util.List;

public interface RoomDAO {
    public List<Room> getAll();
    public Room getById(int id);
    public void add(Room room);
    public void update(Room room);
    public void delete(int id);
}
