package dao.hibernate;
import model.Student;

import java.util.List;

/**
 * Created by vlad on 10.11.16.
 */
public interface DAOHibernateInterface {

    Student login(String login,String password);
    List<Student> getAll();


}
