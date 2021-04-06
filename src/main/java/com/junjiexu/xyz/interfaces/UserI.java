package com.junjiexu.xyz.interfaces;

import com.junjiexu.xyz.entities.User;

public interface UserI {
	int addUser(User user);
	User getUserByUsername(String email);
}
