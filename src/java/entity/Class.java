package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;

@Entity
@XmlRootElement
public class Class {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private ClassDay classDay;
    @ManyToOne
    private StudGroup studGroup;
    private LocalTime localTime;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Subject subject;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassDay getClassDay() {
        return classDay;
    }

    public void setClassDay(ClassDay classDay) {
        this.classDay = classDay;
    }

    public StudGroup getStudGroup() {
        return studGroup;
    }

    public void setStudGroup(StudGroup studGroup) {
        this.studGroup = studGroup;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
