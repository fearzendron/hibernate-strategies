package br.com.zendron.util;

import br.com.zendron.model.Company;
import br.com.zendron.model.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 18/08/13
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtilAnnotated {

    private static SessionFactory sessionFactory;

    private static Properties properties;

    private static SessionFactory buildSessionFactory(String tenant) {
        try {
            Configuration cfg = new Configuration()
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(People.class)
                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + tenant)
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "ferz1772")
                    .setProperty("hibernate.connection.pool_size", "1")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.current_session_context_class", "thread")
                    .setProperty("hibernate.cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider")
                    .setProperty("hibernate.show_sql", "true")
                    .setProperty("hibernate.hbm2ddl.auto", "update");

            //ThreadLocalSessionContext
            //ServiceRegistry registry = new ServiceRegistryBuilder().configure().buildServiceRegistry();

            return cfg.buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(String tenant) {

        sessionFactory = buildSessionFactory(tenant);

        return sessionFactory;
    }

}
