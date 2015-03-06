package rest;

import dao.LessonDAO;
import dao.JPA;
import entity.Lesson;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/resources/classes/")
@RequestScoped
public class LessonService {
    @Inject
    @JPA
    private LessonDAO lessonDAO;

    @GET
    @Path("/{groupName:\\w+-\\d{2}-\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lesson> findClassesByGroup(@PathParam("groupName") String groupName){
        List<Lesson> lessons = lessonDAO.findByGroup(groupName);
        return lessons;
    }
}
