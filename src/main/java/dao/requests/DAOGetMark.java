package dao.requests;

import dao.DAOConnectionManager;
import dao.DAOInterface;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetMark implements DAOInterface {
    private DAOGetMark() {
    }

    private static String prepareGetMarkRequest(String subject) {
        return "SELECT mark FROM " + subject + " WHERE firstName = ? AND lastName = ?";
    }

    private static String prepareGetMarskRequest(String subject) {
        return "SELECT mark FROM " + subject;
    }


    public static int getMark(String subject, String firstName, String lastName)
            throws SQLException {
        Connection connection = DAOConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(prepareGetMarkRequest(subject));
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        ResultSet queryResult = preparedStatement.executeQuery();
        if (!queryResult.next()) {
            return 0;
        }
        return queryResult.getInt("mark");
    }

    public static ArrayList<Integer> getMarks(String subject) throws SQLException {
        ArrayList<Integer> marks = new ArrayList<>();
        String query = prepareGetMarskRequest(subject);
        Connection connection = DAOConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            marks.add(resultSet.getInt("mark"));
        }
        return marks;

    }
}