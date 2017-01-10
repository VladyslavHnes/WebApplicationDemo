package dao.hibernate;

import model.Student;
import model.Teacher;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by vlad on 10.11.16.
 */
public class DAOHibernateTeacher {

    private Session session = null;
    private Logger logger = Logger.getLogger(DAOHibernateTeacher.class);
    private String loginQuery = "from Teacher AS teacher where teacher.login =:login " +
            "AND teacher.password =:password";

    public DAOHibernateTeacher(){
        this.session = DAOHibernateUtil.getSessionFactory().openSession();
    }

    public Teacher login(String login,String password) {
        Query query = session.createQuery(loginQuery);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (Teacher) query.getSingleResult();
    }

    public void updateTeacher(Teacher teacher) throws SQLException {
        try{
        session = DAOHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(teacher);
        session.getTransaction().commit();
       } catch (Exception e) {
            logger.info(e);
        } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    }

    public List<Teacher> getTeachers() {
        Session session = DAOHibernateUtil.getSessionFactory().openSession();
        List<Teacher> result = (List<Teacher>) session.createQuery("from Teacher").list();
        return result;
    }





}
