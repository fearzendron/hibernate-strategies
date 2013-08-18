package br.com.zendron.util;

import br.com.zendron.model.People;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 17/08/13
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static Properties properties;

    private static SessionFactory buildSessionFactory() {
        try {
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().configure().buildServiceRegistry();
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addResource("People.hbm.xml").addAnnotatedClass(People.class);
            Metadata metadata = metadataSources.buildMetadata();

            //new Configuration().configure().buildSessionFactory();

            return metadata.buildSessionFactory();
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
