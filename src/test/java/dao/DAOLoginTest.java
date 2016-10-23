/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Student;
import model.Teacher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        assertEquals("Vlad", result.getLastName());
        assertEquals("Hnes", result.getFirstName());
        assertEquals("Vlad", result.getLogin());
        assertEquals("Hnes123", result.getPassword());
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
        assertEquals("James", result.getLastName());
        assertEquals("Gosling", result.getFirstName());
        assertEquals("James", result.getLogin());
        assertEquals("Gosling123", result.getPassword());
        assertEquals("Java", result.getSubject());
        
    }    
}
