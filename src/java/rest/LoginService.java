package rest;

import com.auth0.jwt.JWTSigner;
import dao.*;
import entity.*;
import security.EncryptByMD5;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RequestScoped
@Path("/login")
public class LoginService {

    @Inject
    @JPA
    private LoginPersonDAO loginPersonDAO;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String find(LoginPerson loginPerson){
        LoginPerson loginPersonFromDB = loginPersonDAO.find(loginPerson.getLogin());
        String token = null;
        if(loginPerson.getPassword().equals(loginPersonFromDB.getPassword())){
            JWTSigner jwtSigner = new JWTSigner("Angular rocks!");
            try {
                token = jwtSigner.sign(preparePersonForEncode(loginPersonFromDB.getPerson()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "{\"token\": \""+token+"\"}";
    }
    public static Map<String, Object> preparePersonForEncode(Person person) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("firstName",person.getFirstName());
        result.put("lastName",person.getLastName());
        result.put("id",person.getId());
        result.put("wishesCount",person.getMyWishes().size());
        return result;
    }
}
