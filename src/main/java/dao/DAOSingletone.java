package dao;

public class DAOSingletone {
    
    private static DAO dao = new DAO();
    
    private static final DAOSingletone INSTANCE = new DAOSingletone();
    
    private DAOSingletone() {}
    
    public DAO getDAO() {
        return dao;
    }
    
    public static DAOSingletone getInstance() {
        return INSTANCE;
    }
    
    
}
