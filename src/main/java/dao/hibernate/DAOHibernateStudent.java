package dao.hibernate;

import model.Course;
import model.Student;
import org.apache.log4j.Logger;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by vlad on 11.11.16.
 */
public class DAOHibernateStudent implements DAOHibernateInterface {

    private Session session;
    private String loginRequest = "FROM Student AS Student WHERE Student.login =:login " +
            "AND Student.password =:password";
    private String selectStudentRequest = "FROM Student AS Student WHERE Student.login =:login";
    private Logger logger = Logger.getLogger(DAOHibernateStudent.class);

    public DAOHibernateStudent() {
        this.session = DAOHibernateUtil.getSessionFactory().openSession();

    }

    public List<Student> getAll() {
        return session.createQuery("from Student").list();
    }

    public Student login(String login, String password) {
        Query query = session.createQuery(loginRequest);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (Student) query.getSingleResult();
    }

    public boolean ifUserExists(String login, String password) {
        Query query = session.createQuery(selectStudentRequest);
        query.setParameter("login", login);
        try {
            Student student = (Student) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            logger.info(e);
            return false;
        }
        return true;
    }

    public int getMark(String subject, String firstName, String lastName) {
        String queryString = String.format("FROM %s AS %s WHERE %s.firstName =:fn AND %s.lastName =:ln",
                subject, subject, subject, subject);
        Query query = session.createQuery(queryString);
        query.setParameter("fn", firstName);
        query.setParameter("ln", lastName);
        Course obj = (Course) query.getSingleResult();
        return obj.getMark();
    }

    public boolean registry(String firstName, String lastName, String login, String password) {
        if (!ifUserExists(login, password)) {
            Transaction txn = session.beginTransaction();
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setLogin(login);
            student.setPassword(password);
            session.save(student);
            txn.commit();
            return true;
        } else {
            return false;
        }
    }

    public void setImageURL(String imageURL, String login){
        Transaction tx = session.beginTransaction();
        String setImageQuery = "update Student s set s.imageURL = :img where s.login = :lgn";
        Query query = session.createQuery(setImageQuery);
        query.setParameter("img", imageURL);
        query.setParameter("lgn",login);
        query.executeUpdate();
        tx.commit();
    }

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