package eu.codeacademy.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import java.lang.module.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

            SessionFactory createdFactory = meta.getSessionFactoryBuilder().build();

            return createdFactory;

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
