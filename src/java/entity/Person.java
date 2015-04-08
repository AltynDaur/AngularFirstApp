package entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement
public class Person {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Person> needForGift;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Wish> myWishes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Person> getNeedForGift() {
        return needForGift;
    }

    public void setNeedForGift(List<Person> needForGift) {
        this.needForGift = needForGift;
    }

    public List<Wish> getMyWishes() {
        return myWishes;
    }

    public void setMyWishes(List<Wish> myWishes) {
        this.myWishes = myWishes;
    }
}
