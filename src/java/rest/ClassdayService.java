package rest;
import com.sun.net.httpserver.HttpServer;
import entity.ClassDay;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("/resources/classdays")
public class ClassdayService {

    @GET
    @Path("/{groupName:\\w+-\\d{2}-\\d+}")
    @Produces("application/json")
    public List<ClassDay> getClassdaysByGroupName(@PathParam("groupName") String groupName) {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        return null;
    }




}
