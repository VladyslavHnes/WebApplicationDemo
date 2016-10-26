/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.requests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAOConnectionManager;
import dao.DAOInterface;
import model.Student;
import model.Teacher;
import model.User;

/**
 *
 * @author Admin
 */
public final class DAOLogin implements DAOInterface {
    
    final static String StudentSelectRequest = "SELECT * FROM students WHERE login = ? and password = ?";
    final static String TeacherSelectRequest = "SELECT * FROM teachers WHERE login = ? and password = ?";

    private DAOLogin(){}

    
    //Check if there is a student with current login and password and return object
    //If there is no the student, then return null
    public static Student studentRequest(String login, String password) throws SQLException{
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(StudentSelectRequest);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet queryResult = preparedStatement.executeQuery();
        if(!queryResult.next()){
            return null;
        }
        Student student = new Student();
        DAOLogin.getUserObject(queryResult,student);
        return student;
    }
    
    //Get object from result set that we generate when we send student request
    public static void getUserObject(ResultSet resultSet, User user)throws SQLException{
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
    }
    
    //Check if there is a teacher with current login and password and return object
    //If there is no the teacher, then return null
    public static Teacher teacherRequest(String login, String password) throws SQLException{
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(TeacherSelectRequest);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet queryResult = preparedStatement.executeQuery();
        if(!queryResult.next()){
            return null;
        }
        Teacher teacher = DAOLogin.getTeacherObject(queryResult); 
        return teacher;
    }
    
    //Get teacher object from result set that we generate when we send teacher request
    public static Teacher getTeacherObject(ResultSet resultSet)throws SQLException{
        Teacher teacher = new Teacher();
        DAOLogin.getUserObject(resultSet, teacher);
        teacher.setSubject(resultSet.getString("subject"));
        return teacher;
    }
}
