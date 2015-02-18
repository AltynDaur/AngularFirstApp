package resources;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
    @PersistenceContext(unitName = "ScheduleDS")
    @Produces
    private EntityManager entityManager;
}
