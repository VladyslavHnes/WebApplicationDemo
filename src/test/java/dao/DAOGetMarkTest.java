package dao;

import dao.jdbc.DAOGetMark;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetMarkTest {

    @Test
    public void getMarksTest() throws SQLException {
        String subject = "Java";
        Integer result = 5;
        assertEquals(result, DAOGetMark.getMarks(subject).get(0));
    }

    @Test
    public void getMarkTest() throws SQLException {
        String subject = "Java";
        String firstName = "Vlad";
        String lastName = "Hnes";
        int result = 5;
        assertEquals(result, DAOGetMark.getMark(subject,firstName,lastName));
    }
}
