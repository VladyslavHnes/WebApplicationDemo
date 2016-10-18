/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAOLogin.StudentSelectRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vlad
 */
public class DAOSetMark {
    
     static String prepareSetMark(String subject){
        return "UPDATE " + subject + " SET mark = ? WHERE lastName = ? AND firstName = ?";
    }
    
    public static int setMark(String subject, int mark, String lastName, String firstName) throws SQLException{
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(prepareSetMark(subject));
        preparedStatement.setInt(1,mark);
        preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,firstName);
        return preparedStatement.executeUpdate();
    }
    
}
