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
import java.sql.SQLException;

/**
 *
 * @author vlad
 */
public class DAOSetMark implements DAOInterface {

    private DAOSetMark(){}
    
    private static String prepareSetMark(String subject){
        return "UPDATE " + subject + " SET mark = ? WHERE lastName = ? AND firstName = ?";
    }
    
    public static int setMark(String subject, int mark, String firstName, String lastName){
        Logger logger = Logger.getLogger(SetImageTeacherController.class);
        Connection connection = DAOConnectionManager.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(prepareSetMark(subject))) {
            preparedStatement.setInt(1, mark);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.close();
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.info(e);
            return -1;
        }
    }
}
