package repn.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import repn.dao.UserDao;
import repn.model.User;
import repn.services.UserManager;
import repn.services.exception.ObjectAlreadyExistsException;

@Transactional(isolation=Isolation.SERIALIZABLE)
@Service()
public class UserManagerImpl implements UserManager{
	
	@Autowired
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) throws ObjectAlreadyExistsException {
		if(getUserByLogin(user.getLogin()) != null)
			throw new ObjectAlreadyExistsException();
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<User> getAllUsers(boolean active) {
		return userDao.getAllUsers(active);
	}

}