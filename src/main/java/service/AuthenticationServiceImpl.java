package service;

import DAO.UserDAOImpl;
import pojos.User;

public class AuthenticationServiceImpl {
	
	private static UserDAOImpl userDao = new UserDAOImpl();
	
	public User validateUser(String username, String password) {
		User user = userDao.readUser(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

}
