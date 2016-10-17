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
    
    final static String SetMarkRequest = "UPDATE ? SET mark = ? WHERE lastName = ? AND firstName = ?";
    
    public static void setMark(String subject, int mark, String lastName, String firstName) throws SQLException{
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SetMarkRequest);
        preparedStatement.setString(1,subject);
        preparedStatement.setInt(2,mark);
        preparedStatement.setString(3,lastName);
        preparedStatement.setString(4,firstName);
        preparedStatement.executeUpdate();
    }
    
}
