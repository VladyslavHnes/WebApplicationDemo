package dao.requests;

import dao.DAOConnectionManager;
import dao.DAOInterface;
import model.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetStudents implements DAOInterface {
    private static String prepareGetStudentsRequest(String subject){
        return "SELECT * FROM " + subject;
    }

    public static ArrayList<Student> getStudents(String subject) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        String request = prepareGetStudentsRequest(subject);
        Connection connection = DAOConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);
        while(resultSet.next()){
            Student student = new Student();
            student.setFirstName(resultSet.getString("firstName"));
            student.setLastName(resultSet.getString("lastName"));
            students.add(student);
        }
        return students;
    }
}
