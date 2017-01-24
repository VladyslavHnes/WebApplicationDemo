package dao;

import dao.jdbc.DAOSubscribe;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 26.10.16.
 */
public class DAOSubscribeTest {

    @Test
    public void testSubscribe() throws SQLException {
        System.out.println("subscribe");
        String subject = "Java";
        String lastName = "Ruslan";
        String firstName = "Vdovichenko";
        int expResult = 1;
        int result = DAOSubscribe.subscribe(subject,lastName,firstName);
        assertEquals(expResult, result);
    }
}