package rest;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import dao.JPA;
import dao.PersonDAO;
import dao.WishDAO;
import dto.WishDTO;
import entity.Person;
import entity.Wish;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

    @Inject
    @JPA
    private WishDAO wishDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Wish> listOfAllWishesOfThisPerson(@HeaderParam("authorization") final String token){
        Map<String,Object> personFromToken = getPersonFromToken(token);
        Person thisPerson = personDAO.getById((int) personFromToken.get("id"));
        return thisPerson.getMyWishes();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Wish addWish(WishDTO wishDTO, @HeaderParam("authorization")final String token){


        try {
            Map<String,Object> personFromToken = getPersonFromToken(token);
            Person thisPerson = personDAO.getById((Integer) personFromToken.get("id"));
            Wish wish = new Wish();
            wish.setWhat(wishDTO.getWhat());
            wish.setCount(wishDTO.getCount());
            wish = wishDAO.add(wish);
            thisPerson.getMyWishes().add(wish);
            personDAO.update(thisPerson);
            return wish;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PUT
    public Response updateWish(Wish wish){
        Response.ResponseBuilder builder = null;
        try {
            wishDAO.update(wish);
            builder = Response.ok();
        } catch (Exception e) {
            Map<String,Object> errors = new HashMap<>();
            errors.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(errors);
        }
        return  builder.build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    public Response deleteWishById(@PathParam("id") int id, @HeaderParam("authorization") final String token){
        Response.ResponseBuilder builder = null;

        try {
            wishDAO.delete(id);
            builder = Response.ok();
        } catch (Exception e) {
            Map<String,Object> errors = new HashMap<>();
            errors.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(errors);
        }
        return builder.build();
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
