package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by vlad on 28.08.2016.
 */

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)

public class DAO{

    public final String Adress;
    public final String Port;
    public final String DatabaseName;
    public final String UserName;
    public final String PassworD;

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
        return userName;
    }

    @XmlAttribute
    public String getPassword() {
        return passworD;
    }

    
    public static void connectToDB() throws  SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + , USERNAME, PASSWORD);
        
    }




    public static void initializeDatabesProperties() throws JAXBException{
        File file = new File("./src/resources/database.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
    }
}