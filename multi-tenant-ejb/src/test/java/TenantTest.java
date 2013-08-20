import br.com.zendron.model.Company;
import br.com.zendron.util.HibernateUtilAnnotated;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 17/08/13
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public class TenantTest {

    @BeforeClass
    public static void init() throws Exception {
        final Properties p = new Properties();

    }

    @Test
    public void verificaSalvamentoAnnotado() {

        String[] tenants = {"banco1","banco2"};

        for (String tenant : tenants) {

            SessionFactory sessionFactory = HibernateUtilAnnotated.getSessionFactory(tenant);
            //Session session = cfg.buildSessionFactory().withOptions().tenantIdentifier("banco1").openSession();

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

    @Test
    public void dynamicSave() {

    }

}
