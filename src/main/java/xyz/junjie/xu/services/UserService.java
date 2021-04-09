package xyz.junjie.xu.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import xyz.junjie.xu.daos.UserDao;
import xyz.junjie.xu.entities.User;
import xyz.junjie.xu.exceptions.InvalidPasswordException;
import xyz.junjie.xu.exceptions.InvalidUsernameException;

public class UserService {
	public void registerUser(User user) throws InvalidPasswordException, InvalidUsernameException {
		String password = user.getPassword();
		if (password.length() < 3) {
			throw new InvalidPasswordException("password is too short.");
		}
		if (!user.getUsername().contains("@")) throw new InvalidUsernameException("username is invalid");
		String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		user.setPassword(bcryptHashString);
		UserDao userDao = new UserDao();
		userDao.addUser(user);
	}
}
