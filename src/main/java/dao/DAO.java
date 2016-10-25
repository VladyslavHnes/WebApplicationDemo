package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.io.File;
import javax.xml.bind.JAXB;

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)

class DAO{

    @XmlElement
    public String address;
    @XmlElement
    public int port;
    @XmlElement
    public String databaseName;
    @XmlElement
    public String user;
    @XmlElement
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
    
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    

    static DAO initializeDatabaseProperties() throws JAXBException {
        ClassLoader classLoader = DAO.class.getClassLoader();
        File file = new File(classLoader.getResource("database/credentials.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        DAO dao = JAXB.unmarshal(file, DAO.class);
        return dao;
    }
    
    static DAO initializeDatabaseProperties(String pathToXML) throws JAXBException {
        ClassLoader classLoader = DAO.class.getClassLoader();
        File file = new File(classLoader.getResource(pathToXML).getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(DAO.class);
        DAO dao = JAXB.unmarshal(file, DAO.class);
        return dao;
    }
}