package dao.hibernate;


import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Created by vlad on 10.11.16.
 */
public class DAOHibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
