package br.com.zendron.ejb;

import br.com.zendron.util.HibernateUtilAnnotated;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.jdbc.connections.internal.MultiTenantConnectionProviderInitiator;
import org.hibernate.service.jdbc.connections.spi.AbstractMultiTenantConnectionProvider;
import org.hibernate.service.jdbc.connections.spi.MultiTenantConnectionProvider;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 19/08/13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class PeopleJPA implements PeopleEJB {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(PeopleEJB people) {
        em.persist(people);
    }

    @Override
    public void saveWithouPersistContext(PeopleEJB people) {
        SessionFactory sessionFactory = HibernateUtilAnnotated.getSessionFactory("banco1");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();


        session.save(people);
        session.getTransaction().commit();
        session.getSessionFactory().close();

    }
}
