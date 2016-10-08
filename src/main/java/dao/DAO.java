package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by vlad on 28.08.2016.
 */

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)

public class DAO{

    public static String Adress;
    public static String Port;
    public static String DatabaseName;
    public static String UserName;
    public static String Password;

    @XmlAttribute
    public String getAdress() {
        return Adress;
    }


    @XmlAttribute
    public String getPort() {
        return Port;
    }


    @XmlAttribute
    public String getDatabaseName() {
        return DatabaseName;
    }


    @XmlAttribute
    public String getUser_name() {
        return UserName;
    }

    @XmlAttribute
    public String getPassword() {
        return Password;
    }

    
    public static void connectToDB() throws  SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ DatabaseName + UserName + Password);
        
        
    }




    public static void initializeDatabesProperties() throws JAXBException{
        File file = new File("./src/resources/database.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
    }
}