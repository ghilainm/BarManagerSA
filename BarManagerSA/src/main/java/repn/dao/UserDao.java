package repn.dao;

import java.util.List;

import repn.model.User;

public interface UserDao extends Dao<User>{
	
	User getUserByLogin(String login);
	List<User> getAllUsers();
	List<User> getAllUsers(boolean active);

}
