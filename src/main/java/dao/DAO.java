package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)

class DAO{

    @XmlAttribute
    public String address;
    @XmlAttribute
    public int port;
    @XmlAttribute
    public String databaseName;
    @XmlAttribute
    public String rootName;
    @XmlAttribute
    public String userLogin;
    @XmlAttribute
    public String userPassword;
    @XmlAttribute
    public String lastName;
    @XmlAttribute
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

    DAO initializeDatabaseProperties() throws JAXBException{ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("database/credentials.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
        return dao;
    }
}