package xyz.junjie.xu.daos;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import xyz.junjie.xu.entities.Product;
import xyz.junjie.xu.interfaces.ProductI;

public class ProductDao extends AbstractDao implements ProductI{

	
	/** 
	 * returns list of products by specified type
	 * @param type the type of product
	 * @return list of products
	 * 
	 * */
	@Override
	public List<Product> getProductsByType(String type) {
		try {
			System.out.println("getProductsByType");
			System.out.println("type: " + type);
			connect();
			Query query = em.createQuery("SELECT p from Product p WHERE p.type LIKE :type");
			query.setParameter("type", type);
			List<Product> products = query.getResultList();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

	/** 
	 * adds a single product to database
	 * @param product product to be added
	 * @return integer specifying a specifying a successful or failed transaction
	 * 
	 * */
	@Override
	public int addProduct(Product product) {
		try {
//			System.out.println("addProduct");
//			System.out.println("product: " + product);
			connect();
			em.getTransaction().begin();
			em.persist(product);
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
	 * returns a single product specified by productId
	 * @param id id of the product
	 * @return product
	 * 
	 * */
	@Override
	public Product getProductById(int id) {
		try {
//			System.out.println("getProductById");
//			System.out.println("id: " + id);
			connect();
			return em.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}
	
}
