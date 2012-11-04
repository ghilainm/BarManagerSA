package repn.services;

import java.util.List;

import repn.dao.UserDao;
import repn.model.User;
import repn.services.exception.UserAlreadyExistException;

public interface UserManager {
	public void setUserDao(UserDao userDao);

	public void save(User user) throws UserAlreadyExistException;

	public void update(User user);

	public void delete(User user);

	public User findUserByLogin(String login);
	
	public List<User> getAllUsers();
	
	public List<User> getAllUsers(boolean active);
}
