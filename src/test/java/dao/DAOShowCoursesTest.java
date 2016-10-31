package dao;


import dao.requests.DAOShowCourses;
import model.Course;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by vlad on 26.10.16.
 */
public class DAOShowCoursesTest {

    @Test
    public void showCoursesTest() throws Exception{
        Course java = new Course();
        java.setSubject("Java");
        java.setFirstNameOfTeacher("James");
        java.setLastNameOfTeacher("Gosling");
        Course javaScript = new Course();
        java.setSubject("JavaScript");
        java.setFirstNameOfTeacher("Brendan");
        java.setLastNameOfTeacher("Eich");
        Course dataStructures = new Course();
        java.setSubject("DataStructures");
        java.setFirstNameOfTeacher("Thomas");
        java.setLastNameOfTeacher("Cormen");
        assertEquals(java.getSubject(), DAOShowCourses.getCourses().get(0).getSubject());
        assertEquals(java.getFirstNameOfTeacher(), DAOShowCourses.getCourses().get(0).getFirstNameOfTeacher());
        assertEquals(java.getLastNameOfTeacher(), DAOShowCourses.getCourses().get(0).getLastNameOfTeacher());
    }


}