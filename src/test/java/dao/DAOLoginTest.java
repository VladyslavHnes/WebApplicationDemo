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
    
    public DAOLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of studentRequest method, of class DAOLogin.
     */
    @Test
    public void testStudentRequest() throws Exception {
        System.out.println("studentRequest");
        String login = "Sos";
        String password = "Pisos123";
        Student result = DAOLogin.studentRequest(login, password);
        assertEquals("Sos", result.getLastName());
        assertEquals("Pisos", result.getFirstName());
        assertEquals("Sos", result.getLogin());
        assertEquals("Pisos123", result.getPassword());
    }


    /**
     * Test of teacherRequest method, of class DAOLogin.
     */
    @Test
    public void testTeacherRequest() throws Exception {
        System.out.println("teacherRequest");
        String login = "Plato";
        String password = "Grek123";
        Teacher result = DAOLogin.teacherRequest(login, password);
        assertEquals("Plato", result.getLastName());
        assertEquals("Grek", result.getFirstName());
        assertEquals("Plato", result.getLogin());
        assertEquals("Grek123", result.getPassword());
        assertEquals("philosophy", result.getSubject());
        
    }    
}
