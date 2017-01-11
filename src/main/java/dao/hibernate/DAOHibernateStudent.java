package dao.hibernate;

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

    public DAOHibernateStudent(){
        this.session = DAOHibernateUtil.getSessionFactory().openSession();

    }

    public List<Student> getAll() {return session.createQuery("from Student").list();}

    public Student login(String login,String password) {
        Query query = session.createQuery(loginRequest);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (Student) query.getSingleResult();
    }

    public boolean ifUserExists(String login,String password){
        Query query = session.createQuery(selectStudentRequest);
        query.setParameter("login",login);
        try{
            Student student = (Student)query.getSingleResult();
        }catch (NoResultException | NonUniqueResultException e){
            logger.info(e);
            return false;
        }
        return true;
    }

    public int getMark(String subject, String firstName, String lastName){
        Query query = session.createQuery("FROM " + subject + " AS " + subject +" WHERE "+ subject +".firstName =:firstName" +
                " AND "+ subject + ".lastName =:lastName");
        query.setParameter("firstName",firstName);
        query.setParameter("lastName",lastName);
        return (int) query.getSingleResult();
    }

    public boolean registry(String firstName, String lastName, String login, String password){
        if(ifUserExists(login,password)){
            Transaction txn = session.beginTransaction();
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setLogin(login);
            student.setPassword(password);
            txn.commit();
            return true;
        }else{
            return false;
        }
    }
}
