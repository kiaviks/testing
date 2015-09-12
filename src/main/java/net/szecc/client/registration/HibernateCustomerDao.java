package net.szecc.client.registration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCustomerDao implements CustomerDao {
	
	private SessionFactory sessionFactory;
	
	public HibernateCustomerDao() {
		Configuration configuration = new Configuration().configure(/*"/WEB-INF/spring/hibernate.cfg.xml"*/);
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(customer);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}				
	}	
}
