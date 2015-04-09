package dao.jpaimpl;

import dao.JPA;
import dao.RoomDAO;
import entity.Person;
import entity.Room;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@JPA
public class JPARoomDAO implements RoomDAO{

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Room> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(Room.class);
        Root<Room> currentRoom = criteriaQuery.from(Room.class);
        criteriaQuery.select(currentRoom).orderBy(builder.asc(currentRoom.get("id")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Room getById(int id) {
        return entityManager.find(Room.class,id);
    }

    @Override
    public void add(Room room) {
        entityManager.merge(room);
    }

    @Override
    public void update(Room room) {
        entityManager.merge(room);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Room.class,id));
    }
}
