package repn.dao;

import java.util.List;

import repn.model.User;

public interface UserDao {
	
	void save(User user);
	void update(User user);
	void delete(User user);
	User findUserByLogin(String login);
	List<User> getAllUsers();
	List<User> getAllUsers(boolean active);

}
