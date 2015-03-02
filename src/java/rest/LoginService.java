package rest;

import com.auth0.jwt.JWTSigner;
import dao.ChairDAO;
import dao.JPA;
import dao.LoginPersonDAO;
import dao.TeacherDAO;
import entity.Chair;
import entity.LoginPerson;
import entity.Person;
import entity.Teacher;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
@Path("/login")
public class LoginService {

    @Inject
    @JPA
    private LoginPersonDAO loginPersonDAO;

    @Inject
    @JPA
    private ChairDAO chairDAO;

    @Inject
    @JPA
    private TeacherDAO teacherDAO;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String find(LoginPerson loginPerson){
        LoginPerson loginPersonFromDB = loginPersonDAO.find(loginPerson.getLogin());
        String token = null;
        if(loginPerson.getPassword().equals(loginPersonFromDB.getPassword())){
            JWTSigner jwtSigner = new JWTSigner("Angular rocks!");
            try {
                token = jwtSigner.sign(introspect(loginPersonFromDB.getPerson()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "{\"token\": \""+token+"\"}";
    }
    public static Map<String, Object> introspect(Object obj) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        BeanInfo info = Introspector.getBeanInfo(obj.getClass());
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            Method reader = pd.getReadMethod();
            if (reader != null)
                result.put(pd.getName(), reader.invoke(obj));
        }
        return result;
    }
}
