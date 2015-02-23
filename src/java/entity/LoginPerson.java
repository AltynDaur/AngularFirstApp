package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class LoginPerson {
    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String password;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
