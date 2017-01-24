package dao.requests;

import controller.teacher.SetImageTeacherController;
import dao.DAOConnectionManager;
import dao.DAOInterface;
import model.Student;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetStudents implements DAOInterface {

    private static Logger logger = Logger.getLogger(SetImageTeacherController.class);

    private static String prepareGetStudentsRequest(String subject){
        return "SELECT * FROM " + subject;
    }

    public static ArrayList<Student> getStudents(String subject){
        ArrayList<Student> students = new ArrayList<>();
        String request = prepareGetStudentsRequest(subject);
        Connection connection = DAOConnectionManager.getConnection();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                students.add(student);
            }
        }catch (SQLException e){
            logger.info(e);
        }
        return students;
    }
}
