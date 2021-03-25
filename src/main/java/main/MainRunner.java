package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.junjiexu.xyz.daos.ProductDao;
import com.junjiexu.xyz.entities.Product;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ProductDao productDao = new ProductDao();
//		productDao.getProductsByType("MEN").forEach(product -> System.out.println(product.getDetails()));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xyz");
		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.createNativeQuery("DROP TABLE IF EXISTS product").executeUpdate();
//		em.getTransaction().commit();
//		Product p = em.find(Product.class, 1);
//		System.out.println(p.getName());
		Product q = new Product(1, "name1", "CLOTHING/SHIRT", new String[] {"WARM", "SOFT"}, "MEN");
		em.getTransaction().begin();
		em.persist(q);
		em.getTransaction().commit();
	}
}
