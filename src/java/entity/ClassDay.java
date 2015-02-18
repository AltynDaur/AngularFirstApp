package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ClassDay {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate localDate;
    @OneToMany
    private List<Class> classes;
}
