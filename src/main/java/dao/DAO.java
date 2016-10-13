package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
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

    public String address;
    public int port;
    public String databaseName;
    public String rootName;
    public String userLogin;
    public String userPassword;
    public String lastName;
    public String password;
    

    @XmlAttribute
    public String getAdress() {
        return address;
    }

    @XmlAttribute
    public int getPort() {
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
        String userPassword = student.getPassword();
        String userLogin = student.getLogin();
        String query = "SELECT* FROM Students WHERE login = " + userLogin + " AND password = " + userPassword + ");";
        System.out.println("Query: "+ query);
        try{
             conn = ConnectionManager.getConnection(userLogin,userPassword,databaseName);
             stmt=conn.createStatement();
             rs = stmt.executeQuery(query);	        
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

    public void initializeDatabaseProperties() throws JAXBException{ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("database/credentials.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
    }
}