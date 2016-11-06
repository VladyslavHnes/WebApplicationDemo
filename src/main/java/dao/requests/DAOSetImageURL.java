package dao.requests;

import controller.teacher.SetImageTeacherController;
import dao.DAOConnectionManager;
import dao.DAOInterface;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vlad on 03.11.16.
 */
public class DAOSetImageURL implements DAOInterface {

    private static String prepareSetImageURL(String user){
        return "UPDATE " + user + " SET imageURL = ? WHERE lastName = ? AND firstName = ?";
    }

    public static int setImageURL(String user,String imageURL, String firstName, String lastName){
        Logger logger = Logger.getLogger(SetImageTeacherController.class);
        Connection connection = DAOConnectionManager.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(prepareSetImageURL(user))) {
            preparedStatement.setString(1, imageURL);
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
