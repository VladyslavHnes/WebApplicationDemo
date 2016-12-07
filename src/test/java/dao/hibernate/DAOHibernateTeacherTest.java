package dao.hibernate;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by vlad on 10.11.16.
 */
public class DAOHibernateTeacherTest {

    @Test
    public void testDAOHibernateTeacherGetTest(){
        assertEquals("Gosling",new DAOHibernateTeacher().getTeachers().get(0).getLastName());
    }



}