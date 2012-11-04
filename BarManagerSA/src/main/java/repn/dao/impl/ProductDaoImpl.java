package repn.dao.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import repn.dao.ProductDao;
import repn.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Resource
    private SessionFactory sessionFactory;

	@Override
	public void save(Product t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	public void update(Product t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	public void delete(Product t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public Product getProductById(String productId) {
		Session session = sessionFactory.getCurrentSession();
		return (Product)session.createCriteria(Product.class).add(Restrictions.eq("productId", productId)).uniqueResult();
	}

	@Override
	public Collection<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Product.class).list();
	}

}
