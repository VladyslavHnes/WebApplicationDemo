package dao.requests;

import dao.DAOConnectionManager;
import dao.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vlad on 26.10.16.
 */
public class DAOSubscribe implements DAOInterface {

    private DAOSubscribe(){}

    private static String prepareSubscribeRequest(String subject){
        return "INSERT INTO " + subject + "(mark,firstName,lastName) VALUES (?,?,?)";
    }
    public static int subscribe(String subject,String lastName, String firstName)
            throws SQLException {
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(prepareSubscribeRequest(subject));
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,firstName);
        return preparedStatement.executeUpdate();
    }
}
