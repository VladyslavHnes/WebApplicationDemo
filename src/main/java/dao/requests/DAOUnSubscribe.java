package dao.requests;

import dao.DAOConnectionManager;
import dao.DAOInterface;

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

    public static int unSubscribe(String subject,String lastName, String firstName)
            throws SQLException {
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(prepareUnSubscribeRequest(subject));
        preparedStatement.setString(1,lastName);
        preparedStatement.setString(2,firstName);
        return preparedStatement.executeUpdate();
    }
}
