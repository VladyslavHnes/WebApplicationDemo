package dao.hibernate;

import model.Teacher;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vlad on 10.11.16.
 */
public class DAOHibernateTeacher{

    private Session session = null;
    private Logger logger = Logger.getLogger(DAOHibernateTeacher.class);
    private String loginQuery = "from Teacher AS teacher where teacher.login =:login " +
            "AND teacher.password =:password";

    public DAOHibernateTeacher(){
        this.session = DAOHibernateUtil.getSessionFactory().openSession();
    }

    public List<Teacher> getAll() {return session.createQuery("from Teacher").list();}

    public Teacher login(String login,String password) {
        Query query = session.createQuery(loginQuery);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (Teacher) query.getSingleResult();
    }

    /*public void updateTeacher(Teacher teacher) throws SQLException {
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
    }*/


    public void setMark(String subject, int mark, String firstName, String lastName){
        Transaction tx = session.beginTransaction();
        String setMarkQuery = String.format("update %s s set s.mark = :mrk where s.firstName = :fn and s.lastName = :ln",
                subject);
        Query query = session.createQuery(setMarkQuery);
        query.setParameter("fn",firstName);
        query.setParameter("ln",lastName);
        query.setParameter("mrk",mark);
        query.executeUpdate();
        tx.commit();
    }
}
