/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.requests;

import controller.teacher.SetImageTeacherController;
import dao.DAOConnectionManager;
import dao.DAOInterface;
import org.apache.log4j.Logger;

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

    private static Logger logger = Logger.getLogger(SetImageTeacherController.class);

    final static String StudentRegRequest = "INSERT INTO students(firstName,lastName,login,password) VALUES(?,?,?,?)";
    final static String StudentSelectRequest = "SELECT login FROM students WHERE login = ?";
    
    public static boolean regStudent(String firstName,String lastName,String login, String password){
        Connection connection = DAOConnectionManager.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(StudentRegRequest)){
            if(!DAORegistry.ifUserExist(login, password)){
                preparedStatement.setString(1,firstName);
                preparedStatement.setString(2,lastName);
                preparedStatement.setString(3,login);
                preparedStatement.setString(4,password);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            logger.info(e);
            return false;
        }

    }
    
    public static boolean ifUserExist(String login,String password){
        Connection connection = DAOConnectionManager.getConnection();
        try(PreparedStatement preparedSelectStatement = connection.prepareStatement(StudentSelectRequest)) {
            preparedSelectStatement.setString(1, login);
            ResultSet queryResult = preparedSelectStatement.executeQuery();
            return queryResult.next();
        }catch (SQLException e){
            logger.info(e);
            return false;
        }
    }
}
