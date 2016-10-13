package dao;

import javax.xml.bind.JAXBException;

public class DAOSingletone {
    
    private static DAO dao = new DAO();
    
    static {
        try {
            dao.initializeDatabaseProperties();
        } catch (JAXBException ex) {
        }
    }
    
    private static final DAOSingletone INSTANCE = new DAOSingletone();
    
    private DAOSingletone() {}
    
    public DAO getDAO() {
        return dao;
    }
    
    public static DAOSingletone getInstance() {
        return INSTANCE;
    }
    
    
}
