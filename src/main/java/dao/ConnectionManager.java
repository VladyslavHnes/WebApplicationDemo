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
            
      public static Connection getConnection(String userName, String password, String databaseName){
        try{
            String url = "jdbc:mysql://localhost:3306/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            try{            	
               con = DriverManager.getConnection(url,userName,password);   
            }catch (SQLException ex){
               ex.printStackTrace();
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
       return con;
      }
    }
