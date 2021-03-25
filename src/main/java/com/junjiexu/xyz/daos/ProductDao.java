package com.junjiexu.xyz.daos;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import com.junjiexu.xyz.entities.Product;
import com.junjiexu.xyz.interfaces.ProductI;

public class ProductDao extends AbstractDao implements ProductI{

	@Override
	public List<Product> getProductsByType(String type) {
		try {
			connect();
			Query query = em.createQuery("SELECT p from Product p WHERE p.type LIKE :type");
			query.setParameter("type", type);
			List<Product> products = query.getResultList();
			System.out.println("PRINTING " + type + " PRODUCTS");
			products.forEach(product -> {System.out.println(product.getName());
			System.out.println(Arrays.toString(product.getDetails()));});
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

	@Override
	public int addProduct(Product product) {
		try {
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

	@Override
	public Product getProductById(int id) {
		try {
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
