package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Student;
import java.sql.ResultSet;


/**
 * Created by vlad on 28.08.2016.
 */

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)

public class DAO{

    public static String adress;
    public static String port;
    public static String databaseName;
    public static String rootName;
    public static String userLogin;
    public static String userPassword;
    public static String lastName;
    public static String password;
    

    @XmlAttribute
    public String getAdress() {
        return adress;
    }

    @XmlAttribute
    public String getPort() {
        return port;
    }

    @XmlAttribute
    public String getDatabaseName() {
        return databaseName;
    }
    
    @XmlAttribute
    public String getRootName() {
        return rootName;
    }

    @XmlAttribute
    public String getPassword() {
        return password;
    }

    public static Student connectToDB(Student student) throws  SQLException, ClassNotFoundException {
        Connection currentCon = null;
        ResultSet rs = null;  
        Statement stmt = null;
        Connection conn = null;
        userPassword = student.getPassword();
        userLogin = student.getLogin();
        Statement statement  = null;
        String query = "SELECT* FROM Students WHERE login = " + userLogin + " AND password = " + userPassword + ");";
        System.out.println("Your login is " + userLogin);          
        System.out.println("Your password is " + password);
        System.out.println("Query: "+ query);
        try{
             conn = ConnectionManager.getConnection(userLogin,userPassword,databaseName);
             stmt=conn.createStatement();
             rs = stmt.executeQuery(query);	        
             boolean more = rs.next();   
        }catch(Exception ex){
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }finally {
            if (rs != null){
                try {
                    rs.close();
                }catch (Exception e) {}
                rs = null;
            }
	
            if (stmt != null){
                try {
                    stmt.close();
                }catch (Exception e) {}
                stmt = null;
            }
	
            if (currentCon != null){
                try {
                    currentCon.close();
                }catch (Exception e) {
                }
                currentCon = null;
            }   
        }
        return student;
    }

    public static void initializeDatabesProperties() throws JAXBException{
        File file = new File("./src/resources/database.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
    }
}