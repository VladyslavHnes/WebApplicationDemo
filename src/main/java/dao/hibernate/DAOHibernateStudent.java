package dao.hibernate;

import model.Student;
import org.hibernate.Session;
import org.hibernate.jpa.event.internal.core.HibernateEntityManagerEventListener;
import org.hibernate.query.Query;
import org.w3c.dom.Entity;

import java.util.List;

/**
 * Created by vlad on 11.11.16.
 */
public class DAOHibernateStudent implements DAOHibernateInterface {

    private Session session;

    public DAOHibernateStudent(){
        this.session = DAOHibernateUtil.getSessionFactory().openSession();

    }

    public List<Student> getAll() {return session.createQuery("from Student").list();}

    public Student login(String login,String password) {
        Query query = session.createQuery("from Student AS student where student.login =:login " +
                        "AND student.password =:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (Student) query.getSingleResult();
    }


}
