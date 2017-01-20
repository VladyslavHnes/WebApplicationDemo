package dao.hibernate;

import controller.teacher.SetImageTeacherController;
import dao.requests.DAOShowCourses;
import model.*;
import org.apache.log4j.Logger;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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



    //set subject and subscribe method
    public void subcribe(String subject,String firstName,String lastName){
        Transaction tx = session.beginTransaction();
        if(subject.equals("Java")){
            Java java = new Java();
            java.setFirstName(firstName);
            java.setLastName(lastName);
            session.save(java);
        }else if(subject.equals("JavaScript")){
            JavaScript javaScript = new JavaScript();
            javaScript.setFirstName(firstName);
            javaScript.setLastName(lastName);
            session.save(javaScript);
        }else {
            DataStructures dataStructures = new DataStructures();
            dataStructures.setFirstName(firstName);
            dataStructures.setLastName(lastName);
            session.save(dataStructures);
        }
        tx.commit();
    }

    public void unSubscribe(String subject,String lastName, String firstName) {
        Transaction tx = session.beginTransaction();
        String deleteQuery = String.format("delete from %s c where c.firstName = :fn and c.lastName = :ln", subject);
        Query query = session.createQuery(deleteQuery);
        query.setParameter("fn",firstName);
        query.setParameter("ln",lastName);
        query.executeUpdate();
        tx.commit();
    }


        /**public static List<Course> getCourses(){
            Logger logger = Logger.getLogger(SetImageTeacherController.class);
            List<Course> arrayList = new ArrayList<>();
            Class cl = DAOShowCourses.class;
            ClassLoader classLoader = cl.getClassLoader();
            URL urlCourses = classLoader.getResource("database/Courses");
            File fileCourses = new File(urlCourses.getPath());
            URL urlTeachers = classLoader.getResource("database/Teachers");
            File fileTeachers = new File(urlTeachers.getPath());
            try(
                    java.io. BufferedReader brCourses = new BufferedReader(new FileReader(fileCourses));
                    java.io. BufferedReader brTeacher = new BufferedReader(new FileReader(fileTeachers))
            ) {
                String lineCourses;
                String lineTeachers;
                while(((lineCourses = brCourses.readLine()) != null) &&
                        (lineTeachers = brTeacher.readLine()) != null) {
                    /**Course course = new Course();
                     course.setSubject(lineCourses);
                     String [] teacherLastNameAndFirstName = lineTeachers.split(" ");
                     course.setFirstNameOfTeacher(teacherLastNameAndFirstName[0]);
                     course.setLastNameOfTeacher(teacherLastNameAndFirstName[1]);
                     arrayList.add(course);
                     /
                }
            }catch (IOException e) {
                logger.info(e);
            }
            return arrayList;
        }*/

}