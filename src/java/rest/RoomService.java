package rest;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import dao.JPA;
import dao.PersonDAO;
import dao.RoomDAO;
import dto.RoomDTO;
import entity.Person;
import entity.Room;
import randomshuffle.RandomShuffle;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.*;
import java.util.regex.Pattern;

@RequestScoped
@Path("/room")
public class RoomService {
    @Inject
    @JPA
    private RoomDAO roomDAO;

    @Inject
    @JPA
    private PersonDAO personDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms(){
        return roomDAO.getAll();
    }

    @GET
    @Path("/myRooms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getCurrentUserRooms(@HeaderParam("authorization") final String token){
        Map<String,Object> currentUser = getPersonFromToken(token);
        Person currentPerson = personDAO.getById((Integer) currentUser.get("id"));
        List<Room> allRooms = roomDAO.getAll();
        List<Room> targetListOfRooms = new ArrayList<Room>();
        for (int i = 0; i < allRooms.size(); i++) {
            List<Person> allPersonFromOneRoom = allRooms.get(i).getRoomMates();
            if(allPersonFromOneRoom.contains(currentPerson)){
                targetListOfRooms.add(allRooms.get(i));
            }
        }
        return targetListOfRooms;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRoom(RoomDTO roomDTO, @HeaderParam("authorization") final String token){
        Response.ResponseBuilder builder = null;

        try {
            Map<String,Object> roomCreator = getPersonFromToken(token);
            Person creatorFromDB = personDAO.getById((int) roomCreator.get("id"));
            Room room = new Room();
            List<Person> roomMates = new ArrayList<Person>();
            room.setName(roomDTO.getName());
            roomMates.add(creatorFromDB);
            room.setRoomMates(roomMates);
            room.setAdmin(creatorFromDB);
            room = roomDAO.add(room);
            builder = Response.ok();
        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }

    @POST
    @Path("/shuffle")
    public Response shuffleSecretSantas(int roomId){
        Response.ResponseBuilder builder = null;
        try {
            Room currentRoom = roomDAO.getById(roomId);
            currentRoom.setRoomMates(RandomShuffle.shuffleSantasToPersons(currentRoom.getRoomMates()));
            roomDAO.update(currentRoom);
            builder = Response.ok();
        } catch (Exception e) {
            Map<String, Object> errors = new HashMap<>();
            errors.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(errors);
        }
        return builder.build();
    }

    @PUT
    @Transactional
    public Response enterPersonInRoom(int roomId, @HeaderParam("authorization") final String token){
        Response.ResponseBuilder builder = null;
        try {
            Map<String,Object> currentPerson = getPersonFromToken(token);
            Room currentRoom = roomDAO.getById(roomId);
            Person personFromDB = personDAO.getById((Integer) currentPerson.get("id"));
            if(!currentRoom.getRoomMates().contains(personFromDB)){
                currentRoom.getRoomMates().add(personFromDB);
                currentRoom = roomDAO.update(currentRoom);
                builder = Response.ok();
            } else {
                builder = Response.notModified();
            }


        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }

    @PUT
    @Path("/removePerson")
    public Response removePersonFromRoom(){
        return null;
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
