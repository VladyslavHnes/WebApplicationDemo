/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.requests.DAORegistry;
import org.junit.Test;

import java.sql.SQLException;

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
    public void testRegStudent() throws SQLException {
        String lastName = "Paul";
        String firstName = "Godric";
        String login = "Paul";
        String password = "Godric123";
        boolean expResult = false;
        boolean result = DAORegistry.regStudent(lastName, firstName, login, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of ifUserExist method, of class DAORegistry.
     */
    @Test
    public void testIfUserExist() throws SQLException {
        String login = "Vlad";
        String password = "Hnes123";
        boolean result = DAORegistry.ifUserExist(login, password);
        assertEquals(true, result);
    }
    
}
