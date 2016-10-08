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
    public static String userName;
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

    public static void connectToDB(Student student) throws  SQLException, ClassNotFoundException {
        
        password = student.getPassword();
        
        Statement statement  = null;
        String query = "SELECT* FROM Students WHERE LOGIN = " + firstName + ""
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ databaseName, rootName, password);
        
        
    }




    public static void initializeDatabesProperties() throws JAXBException{
        File file = new File("./src/resources/database.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
    }
}