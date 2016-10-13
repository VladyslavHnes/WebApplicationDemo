package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)

class DAO{

    public String address;
    public int port;
    public String databaseName;
    public String rootName;
    public String userLogin;
    public String userPassword;
    public String lastName;
    public String password;
    
    DAO() {}
    
    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public String getDatabaseName() {
        return databaseName;
    }
    
    public String getRootName() {
        return rootName;
    }

    public String getPassword() {
        return password;
    }

    public DAO initializeDatabaseProperties() throws JAXBException{ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("database/credentials.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
        return dao;
    }
}