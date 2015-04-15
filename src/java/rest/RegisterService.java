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
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    @Transactional
    public Response register(RegisterPersonDTO registerPersonDTO){
        Response.ResponseBuilder builder = null;

        if(registerPersonDTO.getPassword().equals(registerPersonDTO.getRepeatPassword())){
            LoginPerson loginPerson = new LoginPerson();
            loginPerson.setLogin(registerPersonDTO.getLogin());
            loginPerson.setPassword(registerPersonDTO.getPassword());
            loginPerson = loginPersonDAO.add(loginPerson);
            Person person = new Person();
            person.setId(loginPerson.getId());
            person.setFirstName(registerPersonDTO.getFirstName());
            person.setLastName(registerPersonDTO.getLastName());
            person = personDAO.add(person);
            builder = Response.ok();
        } else {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", "Passwords not equal!");
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }

    private void findSecretSanta(Person person) {
        List<Person> santas = personDAO.getAll();
        boolean addFlag = false;
        for (int i = 0; i < santas.size(); i++) {
            if(santas.get(i).getNeedForGift().isEmpty() && !santas.get(i).equals(person)) {
                santas.get(i).getNeedForGift().add(person);
                personDAO.update(santas.get(i));
                addFlag = true;
            }
            if(addFlag){
                break;
            }
        }
        if(!addFlag){
            Random random = new Random();
            Person randomPerson = santas.get(random.nextInt(santas.size()));
            randomPerson.getNeedForGift().add(person);
            personDAO.update(randomPerson);
        }
    }
}
