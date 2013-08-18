import br.com.zendron.model.Company;
import br.com.zendron.model.People;
import br.com.zendron.util.HibernateUtil;
import br.com.zendron.util.HibernateUtilAnnotated;
import br.com.zendron.util.HibernateUtilOld;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 17/08/13
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public class TenantTest {

    @Test
    public void VerificaSalvamentoEmTenant() {

        Properties properties = new Properties();
        properties.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
        properties.setProperty("connection.url", "jdbc:mysql://localhost:3306/banco1");
        properties.setProperty("connection.username", "root");
        properties.setProperty("connection.password", "ferz1772");
        properties.setProperty("connection.pool_size", "1");
        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("current_session_context_class", "thread");
        properties.setProperty("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
        properties.setProperty("show_sql", "true");
        properties.setProperty("hbm2ddl.auto", "update");

        Configuration cfg = new Configuration().addProperties(properties);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); //cfg.buildSessionFactory(new ServiceRegistryBuilder().configure().buildServiceRegistry());

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        People p = new People();
        p.setId(1);
        p.setName("Teste");
        p.setLastName("Teste");

        session.save(p);

        session.getTransaction().commit();
        session.getSessionFactory().close();

        System.out.print("ola");

    }

    @Test
    public void verificaSalvamentoAnnotado() {

        SessionFactory sessionFactory = HibernateUtilAnnotated.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Company c = new Company();
        c.setId(1);
        c.setName("Company teste");

        session.save(c);

        session.getTransaction().commit();
        session.getSessionFactory().close();

    }

}
