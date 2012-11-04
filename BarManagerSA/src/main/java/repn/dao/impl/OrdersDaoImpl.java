package repn.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import repn.dao.OrdersDao;
import repn.model.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	
	@Resource
    private SessionFactory sessionFactory;

	
	@Override
	public void save(Orders t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	public void update(Orders t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	public void delete(Orders t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

}
