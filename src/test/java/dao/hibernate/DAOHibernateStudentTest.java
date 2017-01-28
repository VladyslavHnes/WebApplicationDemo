package dao.hibernate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 11.11.16.
 */
public class DAOHibernateStudentTest {

    @Test
    public void testDAOHibernateGetStudentsTest(){
        assertEquals("Hnes", DAOHibernateStudent.getAll().get(0).getLastName());
    }

    @Test
    public void testDAOHibernateLoginStudentTest(){
        assertEquals("Hnes", DAOHibernateStudent.login("Vlad","nes123").getLastName());
    }

    @Test
    public void testDAOHibernateIfUserExists(){
        assertEquals(true, DAOHibernateStudent.ifUserExists("Vlad","Hnes123"));
    }

    @Test
    public void testDAOHibernateRegistry(){
        assertEquals(true, DAOHibernateStudent.registry("Chris","Pratt","Chris","Pratt123"));
    }

    @Test
    public void testDAOHibernateGetMark(){
        assertEquals(4, DAOHibernateStudent.getMark("JavaScript","Vlad","Hnes"));
    }

}