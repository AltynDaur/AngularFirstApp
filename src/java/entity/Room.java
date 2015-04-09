package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement
public class Room {
    @Id
    private int id;
    private String name;
    @OneToOne
    private Person admin;
    @OneToMany
    private List<Person> roomMates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getAdmin() {
        return admin;
    }

    public void setAdmin(Person admin) {
        this.admin = admin;
    }

    public List<Person> getRoomMates() {
        return roomMates;
    }

    public void setRoomMates(List<Person> roomMates) {
        this.roomMates = roomMates;
    }
}
