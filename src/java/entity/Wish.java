package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Wish {
    @Id
    @GeneratedValue
    private int id;
    private String what;
    private int count;
    private int santasAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSantasAnswer() {
        return santasAnswer;
    }

    public void setSantasAnswer(int santasAnswer) {
        this.santasAnswer = santasAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wish wish = (Wish) o;

        return id == wish.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
