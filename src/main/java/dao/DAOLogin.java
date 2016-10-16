/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;
import model.Teacher;

/**
 *
 * @author Admin
 */
public class DAOLogin{
    final static String studentRequest = "SELECT * FROM students WHERE login = ? and password = ?";
    final static String teacherRequest = "SELECT * FROM teachers WHERE login = ? and password = ?";
    static ResultSet studentResSet;
    static ResultSet teacherResSet;
    
    
    //Check if there is a student with current login and password and return object
    //If there is no the student, then return null
    public static Student studentRequest(String login, String password) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(studentRequest);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet queryResult = preparedStatement.executeQuery();
        queryResult.next();
        String lastName = queryResult.getString("lastName");
        if(queryResult != null){
            return DAOLogin.getStudentObject(queryResult);
        }else{
            return null;
        }
    }
    
    //Get student object from result set that we generate when we send student request
    public static Student getStudentObject(ResultSet resultSet)throws SQLException{
        Student student = new Student();
        student.setFirstName(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setLogin(resultSet.getString("login"));
        student.setFirstName(resultSet.getString("password"));
        return student;
    }
    
    //Check if there is a teacher with current login and password and return object
    //If there is no the teacher, then return null
    public static Teacher teacherRequest(String login, String password) throws SQLException{
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(teacherRequest);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet queryResult = preparedStatement.executeQuery();
        if(queryResult != null){
            return DAOLogin.getTeacherObject(queryResult);
        }else{
            return null;
        }
    }
    
    //Get teacher object from result set that we generate when we send teacher request
    public static Teacher getTeacherObject(ResultSet resultSet)throws SQLException{
        Teacher teacher = new Teacher();
        teacher.setFirstName(resultSet.getString("firstName"));
        teacher.setLastName(resultSet.getString("lastName"));
        teacher.setLogin(resultSet.getString("login"));
        teacher.setFirstName(resultSet.getString("password"));
        teacher.setSubject(resultSet.getString("subject"));
        return teacher;
    }
}
