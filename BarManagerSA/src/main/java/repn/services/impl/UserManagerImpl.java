package repn.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import repn.dao.UserDao;
import repn.model.User;
import repn.services.UserManager;
import repn.services.exception.UserAlreadyExistException;

@Transactional(isolation=Isolation.SERIALIZABLE)
@Service()
public class UserManagerImpl implements UserManager{
	
	@Autowired
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) throws UserAlreadyExistException {
		if(findUserByLogin(user.getLogin()) != null)
			throw new UserAlreadyExistException();
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
	public User findUserByLogin(String login) {
		return userDao.findUserByLogin(login);
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