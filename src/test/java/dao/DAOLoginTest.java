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
    public void testStudentRequest() throws Exception {
        System.out.println("studentRequest");
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
    public void testTeacherRequest() throws Exception {
        System.out.println("teacherRequest");
        String login = "James";
        String password = "Gosling123";
        Teacher result = DAOLogin.teacherRequest(login, password);
        assertEquals("James", result.getFirstName());
        assertEquals("Gosling", result.getLastName());
        assertEquals("James", result.getLogin());
        assertEquals("Gosling123", result.getPassword());
        assertEquals("Java", result.getSubject());
        assertEquals("http://www.tecmint.com/wp-content/uploads/2013/08/James-Gosling.jpeg",result.getImageURL());
    }    
}
