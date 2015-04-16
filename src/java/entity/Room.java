package entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement
public class Room {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToOne
    private Person admin;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Person> roomMates;
    private boolean isShuffled;

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


    public List<Person> getRoomMates() {
        return roomMates;
    }

    public void setRoomMates(List<Person> roomMates) {
        this.roomMates = roomMates;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getAdmin() {
        return admin;
    }

    public void setAdmin(Person admin) {
        this.admin = admin;
    }

    public boolean isShuffled() {
        return isShuffled;
    }

    public void setShuffled(boolean isShuffled) {
        this.isShuffled = isShuffled;
    }
}
