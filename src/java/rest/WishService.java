package rest;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import dao.JPA;
import dao.PersonDAO;
import dao.WishDAO;
import entity.Person;
import entity.Wish;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RequestScoped
@Path("/wish")
public class WishService {
    @Inject
    @JPA
    private PersonDAO personDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Wish> listOfAllWishesThisPerson(@HeaderParam("authorization") final String token){
        Map<String,Object> personFromToken = getToken(token);
        Person thisPerson = personDAO.getById((Long) personFromToken.get("id"));
        return thisPerson.getMyWishes();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addWish(@HeaderParam("authorization")final String token, Wish wish){
        Response.ResponseBuilder builder = null;

        try {
            Map<String,Object> personFromToken = getToken(token);
            Person thisPerson = personDAO.getById((Long) personFromToken.get("id"));
            thisPerson.getMyWishes().add(wish);
            personDAO.update(thisPerson);
            builder = Response.ok();
        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }

    private Map<String, Object> getToken(String authorizationHeader) {
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
