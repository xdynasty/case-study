package com.junjiexu.xyz.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.junjiexu.xyz.daos.UserDao;
import com.junjiexu.xyz.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao userDao = new UserDao();
		try {
			User user = userDao.getUser(username);
			if (user == null) {
				throw new UsernameNotFoundException("USERNAME NOT FOUND");
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
