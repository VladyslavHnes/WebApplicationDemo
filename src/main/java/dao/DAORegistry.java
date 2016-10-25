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

/**
 *
 * @author vlad
 */
public class DAORegistry implements DAOInterface {

    private DAORegistry(){}
    
    final static String StudentRegRequest = "INSERT INTO students(lastName,firstName,login,password) VALUES(?,?,?,?)";
    final static String StudentSelectRequest = "SELECT login FROM students WHERE login = ?";
    
    public static boolean regStudent(String lastName,String firstName,String login, String password) throws SQLException{
        Connection connection = DAOConnectionManager.getConnection();
        if(!DAORegistry.ifUserExist(login, password)){
            PreparedStatement preparedStatement = connection.prepareStatement(StudentRegRequest);
            preparedStatement.setString(1,lastName);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,login);
            preparedStatement.setString(4,password);
            preparedStatement.executeUpdate();
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean ifUserExist(String login,String password) throws SQLException{
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedSelectStatement = connection.prepareStatement(StudentSelectRequest);
        preparedSelectStatement.setString(1, login);
        ResultSet queryResult = preparedSelectStatement.executeQuery();
        return queryResult.next();
    }
}
