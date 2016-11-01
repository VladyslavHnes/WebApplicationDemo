package dao.requests;

import dao.DAOConnectionManager;
import dao.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOSetSubject implements DAOInterface {

    private DAOSetSubject(){}

    private static String prepareSetSubjectRequest(String subject){
        return "INSERT INTO " + subject + " (mark,firstName,lastName) VALUES (0,?,?)";
    }
    public static int setSubject(String subject,String firstName,String lastName)
            throws SQLException {
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(prepareSetSubjectRequest(subject));
        preparedStatement.setString(1,lastName);
        preparedStatement.setString(2,firstName);
        return preparedStatement.executeUpdate();
    }
}
