/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Student;
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
public class DAOTest {
    
    public DAOTest() {
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
     * Test of getAdress method, of class DAO.
     */
    @Test
    public void testGetAdress() {
        System.out.println("getAdress");
        DAO instance = new DAO();
        String expResult = "localhost";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPort method, of class DAO.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        DAO instance = new DAO();
        String expResult = "3306";
        int result = instance.getPort();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatabaseName method, of class DAO.
     */
    @Test
    public void testGetDatabaseName() {
        System.out.println("getDatabaseName");
        DAO instance = new DAO();
        String expResult = "university";
        String result = instance.getDatabaseName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRootName method, of class DAO.
     */
    @Test
    public void testGetRootName() {
        System.out.println("getRootName");
        DAO instance = new DAO();
        String expResult = "root";
        String result = instance.getRootName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class DAO.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        DAO instance = new DAO();
        String expResult = "021714g";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of initializeDatabesProperties method, of class DAO.
     */
    @Test
    public void testInitializeDatabesProperties() throws Exception {
        System.out.println("initializeDatabesProperties");
        DAOSingletone daoSingletone = DAOSingletone.getInstance();
        DAO dao = daoSingletone.getDAO();
    }
    
}
