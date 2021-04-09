package xyz.junjie.xu.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import xyz.junjie.xu.daos.UserDao;
import xyz.junjie.xu.entities.User;

class TestUserDao {
	UserDao userDao = new UserDao();

	@Test
	void testGetUserByUsername() {
		User expected = new User("junjie325@gmail.com", "pass123", null);
		User actual = userDao.getUserByUsername("junjie325@gmail.com");
		Assertions.assertEquals(expected, actual);
	}

	
	@Test
	void testAddUser() {
		User expected = new User("test@test.com", "test", null);
		userDao.addUser(expected);
		User actual = userDao.getUserByUsername("test@test.com");
		Assertions.assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({"junjie325@gmail.com,pass123", "xyz@gmail.com,123"})
	void testGetUserByUsernameParameterized(ArgumentsAccessor arguments) {
		User expected = new User();
		expected.setUsername(arguments.getString(0));
		expected.setPassword(arguments.getString(1));
		expected.setCartItems(null);
		
		User actual = userDao.getUserByUsername(arguments.getString(0));
		Assertions.assertEquals(expected, actual);
	}
	
}
