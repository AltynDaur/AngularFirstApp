package dao;

import entity.Room;

import java.util.List;

public interface RoomDAO {
    public List<Room> getAll();
    public Room getById(int id);
    public Room add(Room room);
    public Room update(Room room);
    public void delete(int id);
}
