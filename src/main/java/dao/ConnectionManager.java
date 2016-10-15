/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author vlad
 */
 import java.sql.*;


   public class ConnectionManager {

      static Connection con;
      static String url;
      
      private static Connection getConnection(DAO dao){
        try{
            String databaseName = dao.getDatabaseName();
            String address = dao.getAddress();
            int port = dao.getPort();
            String user = dao.getUser();
            String password = dao.getPassword();
            String url = "jdbc:mysql://" + address + ":" + port + "/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            try{            	
               con = DriverManager.getConnection(url, user, password);   
            }catch (SQLException ex){
               ex.printStackTrace();
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
       return con;
      }
    }
