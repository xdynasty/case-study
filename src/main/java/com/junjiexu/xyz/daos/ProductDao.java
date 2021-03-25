package com.junjiexu.xyz.daos;

import java.util.List;

import javax.persistence.Query;

import com.junjiexu.xyz.entities.Product;
import com.junjiexu.xyz.interfaces.ProductI;

public class ProductDao extends AbstractDao implements ProductI{

	@Override
	public List<Product> getProductsByType(String type) {
		try {
			connect();
			Query query = em.createQuery("SELECT p from Product p WHERE type = :type");
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
	
}
