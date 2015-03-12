package rest;
import com.sun.net.httpserver.HttpServer;
import dao.*;
import entity.*;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/resources/classdays")
public class ClassdayService {

    @Inject
    @JPA
    private ChairDAO chairDAO;

    @Inject
    @JPA
    private TeacherDAO teacherDAO;

    @Inject
    @JPA
    private SubjectDAO subjectDAO;

    @Inject
    @JPA
    private GroupDAO studGroupDAO;

    @Inject
    @JPA
    private LessonDAO lessonDAO;

    @Inject
    @JPA
    private ClassDayDAO classDayDAO;

    @GET
    @Path("/{groupName:\\w+-\\d{2}-\\d+}")
    @Produces("application/json")
    public List<ClassDay> getClassdaysByGroupName(@PathParam("groupName") String groupName) {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        return null;
    }

    @POST
    @Consumes("text/plain")
    @Produces("text/plain")
    public String makeSomeStaff(String something){



        return "Vse OK";
    }




}
