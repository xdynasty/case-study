package xyz.junjie.xu.interfaces;

import xyz.junjie.xu.entities.User;

public interface UserI {
	int addUser(User user);
	User getUserByUsername(String email);
}
