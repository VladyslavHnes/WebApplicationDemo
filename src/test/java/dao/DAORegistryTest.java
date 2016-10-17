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
public class DAORegistryTest {
    
    

    /**
     * Test of regStudent method, of class DAORegistry.
     */
    @Test
    public void testRegStudent() throws Exception {
        System.out.println("regStudent");
        String lastName = "las";
        String firstName = "sad";
        String login = "Sossad";
        String password = "Pisos";
        boolean expResult = false;
        boolean result = DAORegistry.regStudent(lastName, firstName, login, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of ifUserExist method, of class DAORegistry.
     */
    @Test
    public void testIfUserExist() throws Exception {
        System.out.println("ifUserExist");
        String login = "Sos";
        String password = "Pisos123";
        boolean expResult = true;
        boolean result = DAORegistry.ifUserExist(login, password);
        assertEquals(expResult, result);
    }
    
}
