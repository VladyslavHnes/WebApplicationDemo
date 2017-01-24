package dao.requests;

import controller.teacher.SetImageTeacherController;
import dao.DAOConnectionManager;
import dao.DAOInterface;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 01.11.16.
 */
public class DAOGetMark implements DAOInterface {

    private DAOGetMark() {
    }

    private static Logger logger = Logger.getLogger(SetImageTeacherController.class);


    private static String prepareGetMarkRequest(String subject) {
        return "SELECT mark FROM " + subject + " WHERE firstName = ? AND lastName = ?";
    }

    private static String prepareGetMarksRequest(String subject) {
        return "SELECT mark FROM " + subject;
    }


    public static int getMark(String subject, String firstName, String lastName){
        Connection connection = DAOConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(prepareGetMarkRequest(subject))){
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet queryResult = preparedStatement.executeQuery();
            if (!queryResult.next()) {
                return 0;
            }
            return queryResult.getInt("mark");
        }catch (SQLException e){
            logger.info(e);
            return -1;
        }
    }

    public static List<Integer> getMarks(String subject){
        ArrayList<Integer> marks = new ArrayList<>();
        String query = prepareGetMarksRequest(subject);
        Connection connection = DAOConnectionManager.getConnection();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                marks.add(resultSet.getInt("mark"));
            }
            return marks;
        }catch (SQLException e){
            logger.info(e);
            return marks;
        }

    }
}