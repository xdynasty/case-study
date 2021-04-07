package xyz.junjie.xu.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import xyz.junjie.xu.daos.UserDao;
import xyz.junjie.xu.entities.User;

public class UserService {
	public void registerUser(User user) {
		String password = user.getPassword();
		String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		user.setPassword(bcryptHashString);
		UserDao userDao = new UserDao();
		userDao.addUser(user);
	}
}
