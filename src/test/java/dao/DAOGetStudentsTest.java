package dao;

import dao.jdbc.DAOGetStudents;
import dao.jdbc.DAOInterface;
import model.Student;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetStudentsTest implements DAOInterface {
    @Test
    public void getStudentsTest() throws SQLException {
        String firstName = "Vlad";
        String lastName = "Hnes";
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        assertEquals(student.getFirstName(), DAOGetStudents.getStudents("Java").get(0).getFirstName());
        assertEquals(student.getLastName(), DAOGetStudents.getStudents("Java").get(0).getLastName());
    }
}
