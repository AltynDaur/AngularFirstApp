package entity;

import javax.persistence.*;

@Entity
public class LoginPerson {
    @Id
    @GeneratedValue
    private long id;
    private String login;
    private byte[] password;
    private byte[] salt;
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

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
