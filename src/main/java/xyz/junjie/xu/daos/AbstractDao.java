package xyz.junjie.xu.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDao {
	EntityManagerFactory emf;
	EntityManager em;
	
	
	/** 
	 * Connect to database
	 * @param none
	 * @return void
	 * */
	public void connect() {
		emf = Persistence.createEntityManagerFactory("xyz");
		em = emf.createEntityManager();
	}

	/** 
	 * Disconnect from database
	 * @param none
	 * @return void
	 * */
	public void disconnect() {
		if (em.isOpen()) em.close();
		if (emf.isOpen()) emf.close();
	}
}
