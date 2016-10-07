package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.net.URL;


/**
 * Created by vlad on 28.08.2016.
 */

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)

public class DAO{

    public  String adresS;
    public  String porT;
    public  String databaseName;
    public  String userName;
    public  String passworD;

    @XmlAttribute
    public String getAdress() {
        return adresS;
    }

    public void setAdress(String adress) {
        this.adresS = adress;
    }

    @XmlAttribute
    public String getPort() {
        return porT;
    }

    public void setPort(String port) {
        this.porT = port;
    }

    @XmlAttribute
    public String getDatabase_name() {
        return databaseName;
    }

    public void setDatabase_name(String database_name) {
        this.databaseName = database_name;
    }

    @XmlAttribute
    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    @XmlAttribute
    public String getPassword() {
        return passworD;
    }

    public void setPassword(String password) {
        this.passworD = password;
    }




    public static void initializeDatabesProperties() throws JAXBException{
        File file = new File("./src/resources/database.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);



    }
}