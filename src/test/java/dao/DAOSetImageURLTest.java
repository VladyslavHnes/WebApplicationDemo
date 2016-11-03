package dao;

import dao.requests.DAOSetImageURL;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 03.11.16.
 */
public class DAOSetImageURLTest {
    @Test
    public void testDAOSetImageURLMethod() throws SQLException {
        System.out.println("setImageURL");
        String imageURL = "http://cp91279.biography.com/BIO_Bio-Shorts_Dick-Cheney-Mini-Biography_0_181273_SF_HD_768x432-16x9.jpg";
        String lastName = "Vlad";
        String firstName = "Hnes";
        int expResult = 1;
        int result = DAOSetImageURL.setImageURL("students",imageURL,lastName,firstName);
        assertEquals(expResult, result);
    }

}