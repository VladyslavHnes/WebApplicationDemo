package dao.hibernate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 11.11.16.
 */
public class DAOHibernateStudentTest {

    @Test
    public void testDAOHibernateGetStudentsTest(){
        assertEquals("Hnes",new DAOHibernateStudent().getAll().get(0).getLastName());
    }

    @Test
    public void testDAOHibernateLoginTest(){
        assertEquals("Hnes",new DAOHibernateStudent().login("Vlad","Hnes123").getLastName());
    }

}