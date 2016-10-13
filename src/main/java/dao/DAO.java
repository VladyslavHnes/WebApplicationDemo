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
    public String getAddress() {
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

    public void initializeDatabaseProperties() throws JAXBException{ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("database/credentials.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
    }
}