package repn.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import repn.dao.UserDao;
import repn.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource
    private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	@Override
	public User getUserByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		return (User)session.createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers(boolean active) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User as user where user.isActive = "+active).list();
	}

}
