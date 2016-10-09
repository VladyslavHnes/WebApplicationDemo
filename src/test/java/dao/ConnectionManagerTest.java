/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
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
public class ConnectionManagerTest {
    
    public ConnectionManagerTest() {
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
     * Test of getConnection method, of class ConnectionManager.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        String userName = "root";
        String password = "021714g";
        String databaseName = "university";
        Connection result = ConnectionManager.getConnection(userName, password, databaseName);
        assertNotNull( "Check if null", result);
    }
    
}
