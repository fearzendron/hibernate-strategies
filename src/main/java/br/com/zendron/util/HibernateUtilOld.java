package br.com.zendron.util;

import br.com.zendron.model.People;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 18/08/13
 * Time: 00:13
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtilOld {

    private static SessionFactory sessionFactory;

    private static Properties properties;

    private static SessionFactory buildSessionFactory() {
        try {

            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }

}
