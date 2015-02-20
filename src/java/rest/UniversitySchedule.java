package rest;

import dao.ChairDAO;
import dao.JPA;
import dao.LoginPersonDAO;
import dao.TeacherDAO;
import entity.Chair;
import entity.LoginPerson;
import entity.Teacher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@ApplicationPath("/schedule")
@ApplicationScoped
public class UniversitySchedule extends Application{

}
