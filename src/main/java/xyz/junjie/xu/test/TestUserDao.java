package xyz.junjie.xu.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
}
