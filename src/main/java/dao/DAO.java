package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
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
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DAO dao = (DAO) unmarshaller.unmarshal(file);
        DAO dao2 = JAXB.unmarshal(file, DAO.class);
        return dao2;
    }
}