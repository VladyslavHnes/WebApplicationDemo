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
    private String loginRequest = "from Student AS student where student.login =:login " +
            "AND student.password =:password";
    private String selectStudentRequest = "from Student AS student WHERE student.login =:login";
    private String insertStudentRequest = "insert into Student(firstName,lastName,login,password) " +
            "select student.firstName, student.lastName,student.login,student.password from Student student";
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
