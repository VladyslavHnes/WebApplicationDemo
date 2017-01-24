/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.jdbc;

/**
 *
 * @author vlad
 */
 import controller.student.SetImageStudentController;
 import dao.jdbc.requests.DAO;
 import org.apache.log4j.Logger;

 import java.sql.*;


public class DAOConnectionManager {

    private DAOConnectionManager(){}
    private static Logger logger = Logger.getLogger(SetImageStudentController.class);

    private static Connection getConnection(DAO dao){
        try{
            String databaseName = dao.getDatabaseName();
            String address = dao.getAddress();
            int port = dao.getPort();
            String user = dao.getUser();
            String password = dao.getPassword();
            String url = "jdbc:mysql://" + address + ":" + port + "/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch(ClassNotFoundException | SQLException e){
            logger.info(e);
        }
        return null;
    }

    private static Connection getConnection(DAOSingletone daoSingletone) {
          DAO dao = DAOSingletone.getInstance().getDAO();
          return getConnection(dao);
    }

    public static Connection getConnection() {
        DAOSingletone daoSingletone = DAOSingletone.getInstance();
        return getConnection(daoSingletone);
    }
}
