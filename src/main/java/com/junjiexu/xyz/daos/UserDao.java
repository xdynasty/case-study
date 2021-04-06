package com.junjiexu.xyz.daos;


import com.junjiexu.xyz.entities.User;
import com.junjiexu.xyz.interfaces.UserI;

public class UserDao extends AbstractDao implements UserI {

	@Override
	public int addUser(User user) {
		try {
			System.out.println("addUser");
			System.out.println("user: " + user);
			connect();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			disconnect();
		}
	}

	@Override
	public User getUserByUsername(String username) {
		try {
			System.out.println("getUser");
			connect();
			return em.find(User.class, username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

}
