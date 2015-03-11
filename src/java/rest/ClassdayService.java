package rest;
import com.sun.net.httpserver.HttpServer;
import dao.*;
import entity.*;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/resources/classdays")
public class ClassdayService {

    @Inject
    @JPA
    private LoginPersonDAO loginPersonDAO;

    @Inject
    @JPA
    private ChairDAO chairDAO;

    @Inject
    @JPA
    private TeacherDAO teacherDAO;

    @Inject
    @JPA
    private SubjectDAO subjectDAO;

    @Inject
    @JPA
    private GroupDAO studGroupDAO;

    @Inject
    @JPA
    private LessonDAO lessonDAO;

    @Inject
    @JPA
    private ClassDayDAO classDayDAO;

    @GET
    @Path("/{groupName:\\w+-\\d{2}-\\d+}")
    @Produces("application/json")
    public List<ClassDay> getClassdaysByGroupName(@PathParam("groupName") String groupName) {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        return null;
    }

    @POST
    @Consumes("text/plain")
    @Produces("text/plain")
    public String makeSomeStaff(String something){
        LoginPerson loginPerson1 = new LoginPerson();
        loginPerson1.setLogin("Yasha");
        loginPerson1.setPassword("Yasha");
        loginPersonDAO.add(loginPerson1);
        loginPerson1 = loginPersonDAO.find("Yasha");
        Chair chair = new Chair();
        chair.setFirstName("Yakov");
        chair.setLastName("Schmidt");
        chair.setId(loginPerson1.getId());
        chair.setChairName("IS");
        chairDAO.add(chair);
        LoginPerson loginPerson2 = new LoginPerson();
        loginPerson2.setLogin("Vasya");
        loginPerson2.setPassword("Vasya");
        loginPersonDAO.add(loginPerson2);
        loginPerson2 = loginPersonDAO.find("Vasya");
        Teacher teacher = new Teacher();
        teacher.setId(loginPerson2.getId());
        teacher.setFirstName("Vasya");
        teacher.setLastName("Pupkin");
        teacher.setChair(chair);
        teacherDAO.add(teacher);
        LoginPerson loginPerson3 = new LoginPerson();
        loginPerson3.setLogin("Petya");
        loginPerson3.setPassword("Petya");
        loginPersonDAO.add(loginPerson3);
        loginPerson3 = loginPersonDAO.find("Petya");
        Teacher teacher1 = new Teacher();
        teacher1.setId(loginPerson3.getId());
        teacher1.setFirstName("Petya");
        teacher1.setLastName("Petrov");
        teacher1.setChair(chair);
        teacherDAO.add(teacher1);
        Subject subject = new Subject();
        subject.setName("Razrabotka PO");
        subject.setChair(chair);
        subjectDAO.add(subject);
        Chair chair1 = chairDAO.find(1);
        Subject subject1 = new Subject();
        subject1.setName("Internet technologies");
        subject1.setChair(chair1);
        subjectDAO.add(subject1);
        Subject subject2 = new Subject();
        subject2.setName("Networks");
        subject2.setChair(chair1);
        subjectDAO.add(subject2);
        StudGroup studGroup = new StudGroup();
        studGroup.setName("VT-13-2");
        studGroup.setChair(chair1);
        studGroupDAO.add(studGroup);
        StudGroup studGroup1 = new StudGroup();
        studGroup1.setName("IS-12-1");
        studGroup1.setChair(chair);
        studGroupDAO.add(studGroup1);
        StudGroup studGroup2 = new StudGroup();
        studGroup2.setName("IS-11-2");
        studGroup2.setChair(chair);
        studGroupDAO.add(studGroup2);
        Teacher teacher2 = teacherDAO.find(0);
        Lesson lesson = new Lesson();
        lesson.setStudGroup(studGroup);
        lesson.setSubject(subject);
        lesson.setTeacher(teacher2);
        lesson.setEveryWeek(true);
        lesson.setLocalTime(LocalTime.of(11,45));
        lessonDAO.add(lesson);
        Lesson lesson1 = new Lesson();
        lesson1.setStudGroup(studGroup);
        lesson1.setTeacher(teacher2);
        lesson1.setSubject(subject2);
        lesson1.setEveryWeek(true);
        lesson1.setLocalTime(LocalTime.of(14, 30));
        lessonDAO.add(lesson1);
        ClassDay classDay = new ClassDay();
        classDay.setLocalDate(LocalDate.of(2015, 3, 12));
        Map<Integer,Lesson> lessons = new LinkedHashMap<>();
        lessons.put(1,lesson);
        lessons.put(3,lesson1);
        classDay.setLessons(lessons);
        classDayDAO.add(classDay);
        return "Vse OK";
    }




}
