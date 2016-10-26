package dao;

import dao.requests.DAOUnSubscribe;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 26.10.16.
 */
public class DAOUnSubscribeTest {

    @Test
    public void testUnSubscribe() throws SQLException {
        System.out.println("UnSubscribe");
        String subject = "Java";
        String lastName = "Ruslan";
        String firstName = "Vdovichenko";
        int expResult = 1;
        int result = DAOUnSubscribe.unSubscribe(subject,lastName,firstName);
        assertEquals(expResult, result);
    }

}