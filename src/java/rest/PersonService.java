package rest;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import dao.JPA;
import dao.PersonDAO;
import entity.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RequestScoped
@Path("/person")
public class PersonService {

    @Inject
    @JPA
    private PersonDAO personDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsWhoNeedForGift(@HeaderParam("authorization")final String token){
        Map<String,Object> personFromToken = getPersonFromToken(token);
        Person currentPerson = personDAO.getById((Integer) personFromToken.get("id"));
        return currentPerson.getNeedForGift();
    }

    private Map<String, Object> getPersonFromToken(String authorizationHeader) {
        String result = null;
        String[] parts = authorizationHeader.split(" ");

        String scheme = parts[0];
        String credentials = parts[1];

        Pattern pattern = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(scheme).matches()) {
            result = credentials;
        }
        long personId = 0;
        Map<String, Object> decodedPayload = null;
        try {
            decodedPayload = new JWTVerifier("Angular rocks!").verify(result);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | JWTVerifyException | IOException e) {
            e.printStackTrace();
        }
        return decodedPayload;
    }
}
