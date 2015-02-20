package entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Entity
@XmlRootElement
public class Teacher extends Person{

    @ManyToOne
    private Chair chair;

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }


}
