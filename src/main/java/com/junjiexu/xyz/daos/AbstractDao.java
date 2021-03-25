package com.junjiexu.xyz.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDao {
	EntityManagerFactory emf;
	EntityManager em;
	
	public void connect() {
		emf = Persistence.createEntityManagerFactory("xyz");
		em = emf.createEntityManager();
	}
	
	public void disconnect() {
		if (em.isOpen()) em.close();
		if (emf.isOpen()) emf.close();
	}
}
