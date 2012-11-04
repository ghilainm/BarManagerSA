package repn.services;

import java.util.List;

import repn.model.User;

public interface UserManager extends Manager<User>{
	
	public User getUserByLogin(String login);
	
	public List<User> getAllUsers();
	
	public List<User> getAllUsers(boolean active);
}
