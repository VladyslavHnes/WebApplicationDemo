package dao.requests;

import dao.DAOConnectionManager;
import dao.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetMark implements DAOInterface {
    private DAOGetMark(){}

    private static String prepareGetMarkRequest(String subject){
        return "SELECT mark FROM " + subject + " WHERE firstName = ? AND lastName = ?";
    }

    public static int getMark(String subject,String firstName,String lastName)
            throws SQLException {
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(prepareGetMarkRequest(subject));
        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2,lastName);
        ResultSet queryResult = preparedStatement.executeQuery();
        if(!queryResult.next()){
            return 0;
        }
        return queryResult.getInt("mark");
    }
}
