package dao;

import javax.xml.bind.JAXBException;

public class DAOSingletone {
    
    private static DAO dao = new DAO();
    private static DAO daoTest = new DAO();
    
    static {
        try {
            dao = DAO.initializeDatabaseProperties();
        } catch (JAXBException ex) {
            ex.toString();
        }
    }
    
    private static final DAOSingletone INSTANCE = new DAOSingletone();
    
    private DAOSingletone() {}
    
    public DAO getDAO() {
        return dao;
    }
    public DAO getDAO(String pathToXML) throws JAXBException {
        return DAO.initializeDatabaseProperties(pathToXML);
    }
    
    
    public static DAOSingletone getInstance() {
        return INSTANCE;
    }
    
    
}
