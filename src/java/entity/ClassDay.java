package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
public class ClassDay {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate localDate;
    @OneToMany
    private Map<Integer,Lesson> lessons;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Map<Integer, Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Map<Integer, Lesson> lessons) {
        this.lessons = lessons;
    }
}
