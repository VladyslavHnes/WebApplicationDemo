package dao.requests;

import controller.teacher.SetImageTeacherController;
import dao.DAOConnectionManager;
import dao.DAOInterface;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vlad on 26.10.16.
 */
public class DAOUnSubscribe implements DAOInterface {

    private DAOUnSubscribe(){}

    private static String prepareUnSubscribeRequest(String subject){
        return "DELETE FROM " + subject + " WHERE lastname = ? AND firstname = ?";
    }

    public static int unSubscribe(String subject,String lastName, String firstName) {
        Connection connection = DAOConnectionManager.getConnection();
        Logger logger = Logger.getLogger(SetImageTeacherController.class);
        try(PreparedStatement preparedStatement = connection.prepareStatement(prepareUnSubscribeRequest(subject))) {
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            preparedStatement.close();
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.info(e);
            return -1;
        }
    }
}
