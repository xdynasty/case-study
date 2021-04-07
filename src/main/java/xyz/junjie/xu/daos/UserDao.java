package xyz.junjie.xu.daos;


import xyz.junjie.xu.entities.User;
import xyz.junjie.xu.interfaces.UserI;

public class UserDao extends AbstractDao implements UserI {

	
	/** 
	 * adds single user to database
	 * @param user user to be added
	 * @return integer specifying a specifying a successful or failed addition
	 * 
	 * */
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

	/** 
	 * retrieves user corresponding to username
	 * @param username username of user
	 * @return User
	 * 
	 * */
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
