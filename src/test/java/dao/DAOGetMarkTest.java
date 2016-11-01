package dao;

import dao.requests.DAOGetMark;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetMarkTest {

    @Test
    public void getMarkTest() throws SQLException {
        String subject = "Java";
        String firstName = "Vlad";
        String lastName = "Hnes";
        int result = 5;
        assertEquals(result, DAOGetMark.getMark(subject,firstName,lastName));
    }
}
