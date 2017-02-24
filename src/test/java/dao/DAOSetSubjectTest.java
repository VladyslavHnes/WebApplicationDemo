package dao;

import dao.jdbc.DAOSetSubject;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOSetSubjectTest {
    @Test
    public void testSetSubject() throws SQLException {
        String subject = "Java";
        String lastName = "Ruslan";
        String firstName = "Vdovichenko";
        int expResult = 1;
        int result = DAOSetSubject.setSubject(subject,firstName,lastName);
        assertEquals(expResult, result);
    }
}
