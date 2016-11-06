/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.requests.DAOLogin;
import model.Student;
import model.Teacher;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 *
 * @author vlad
 */
public class DAOLoginTest {
    
    /**
     * Test of studentRequest method, of class DAOLogin.
     */
    @Test
    public void testStudentRequest() throws SQLException {
        String login = "Vlad";
        String password = "Hnes123";
        Student result = DAOLogin.studentRequest(login, password);
        assertEquals("Vlad", result.getFirstName());
        assertEquals("Hnes", result.getLastName());
        assertEquals("Vlad", result.getLogin());
        assertEquals("Hnes123", result.getPassword());
        assertEquals("https://ih1.redbubble.net/image.175848241.2112/flat,800x800,075,f.jpg",result.getImageURL());
    }


    /**
     * Test of teacherRequest method, of class DAOLogin.
     */
    @Test
    public void testTeacherRequest() throws SQLException {
        String login = "James";
        String password = "Gosling123";
        Teacher result = DAOLogin.teacherRequest(login, password);
        assertEquals("James", result.getFirstName());
        assertEquals("Gosling", result.getLastName());
        assertEquals("James", result.getLogin());
        assertEquals("Gosling123", result.getPassword());
        assertEquals("Java", result.getSubject());
        assertEquals("http://arhivach.org/storage/4/34/4346bfa65d3f8ef55b293c752c3c2dc0.jpg",result.getImageURL());
    }    
}
