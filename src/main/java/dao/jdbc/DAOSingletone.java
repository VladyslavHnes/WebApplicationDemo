package dao.jdbc;

import controller.teacher.SetImageTeacherController;
import dao.jdbc.requests.DAO;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBException;

public class DAOSingletone {

    private static Logger logger = Logger.getLogger(SetImageTeacherController.class);

    private static DAO dao = new DAO();
    private static DAO daoTest = new DAO();

    static {
        try {
            dao = DAO.initializeDatabaseProperties();
        } catch (JAXBException ex) {
            logger.info(ex);
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