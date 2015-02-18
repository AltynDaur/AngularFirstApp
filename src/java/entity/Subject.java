package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Subject {
    @Id
    @GeneratedValue
    private long id;
    @Pattern(regexp = "\\w{3}")
    private String name;
    @ManyToOne
    private Chair chair;
}
