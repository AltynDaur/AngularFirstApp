package rest;


import dao.JPA;
import dao.LoginPersonDAO;
import dao.PersonDAO;
import dto.RegisterPersonDTO;
import entity.LoginPerson;
import entity.Person;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
@Path("/register")
public class RegisterService {
    @Inject
    @JPA
    private LoginPersonDAO loginPersonDAO;

    @Inject
    @JPA
    private PersonDAO personDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(RegisterPersonDTO registerPersonDTO){
        Response.ResponseBuilder builder = null;

        if(registerPersonDTO.getPassword().equals(registerPersonDTO.getRepeatPassword())){
            LoginPerson loginPerson = new LoginPerson();
            loginPerson.setLogin(registerPersonDTO.getLogin());
            loginPerson.setPassword(registerPersonDTO.getPassword());
            loginPersonDAO.add(loginPerson);
            loginPerson = loginPersonDAO.find(registerPersonDTO.getLogin());
            Person person = new Person();
            person.setId(loginPerson.getId());
            person.setFirstName(registerPersonDTO.getFirstName());
            person.setLastName(registerPersonDTO.getLastName());
            personDAO.add(person);
            builder = Response.ok();
        } else {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", "Passwords not equal!");
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }
}
