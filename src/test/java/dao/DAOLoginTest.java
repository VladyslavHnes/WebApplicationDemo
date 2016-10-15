/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
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
 * @author Admin
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
        assertNotNull("Check if not null", result);
    }

    /**
     * Test of getStudentObject method, of class DAOLogin.
     */
    @Test
    public void testGetStudentObject() throws Exception {
        System.out.println("getStudentObject");
        ResultSet resultSet = null;
        Student expResult = null;
        Student result = DAOLogin.getStudentObject(resultSet);
        assertEquals(expResult, result);
    }

    /**
     * Test of teacherRequest method, of class DAOLogin.
     */
    @Test
    public void testTeacherRequest() throws Exception {
        System.out.println("teacherRequest");
        String login = "";
        String password = "";
        Teacher expResult = null;
        Teacher result = DAOLogin.teacherRequest(login, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTeacherObject method, of class DAOLogin.
     */
    @Test
    public void testGetTeacherObject() throws Exception {
        System.out.println("getTeacherObject");
        ResultSet resultSet = null;
        Teacher expResult = null;
        Teacher result = DAOLogin.getTeacherObject(resultSet);
        assertEquals(expResult, result);
    }
    
}
