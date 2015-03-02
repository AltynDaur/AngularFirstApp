package rest;

import dao.ClassDAO;
import entity.*;
import entity.Class;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/resources/classes/")
@RequestScoped
public class ClassesService {
    @Inject
    private ClassDAO classDAO;

    @GET
    @Path("/{groupName:\\w+-\\d{2}-\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Class> findClassesByGroup(@PathParam("groupName") String groupName){
        List<Class> classes = classDAO.findByGroup(groupName);
        return classes;
    }
}
