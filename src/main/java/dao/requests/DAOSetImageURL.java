package dao.requests;

import dao.DAOConnectionManager;
import dao.DAOInterface;

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

    public static int setImageURL(String user,String imageURL, String firstName, String lastName) throws SQLException {
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(prepareSetImageURL(user));
        preparedStatement.setString(1,imageURL);
        preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,firstName);
        return preparedStatement.executeUpdate();
    }
}
