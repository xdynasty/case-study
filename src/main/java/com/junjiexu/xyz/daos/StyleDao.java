package com.junjiexu.xyz.daos;

import java.util.List;
import javax.persistence.Query;

import com.junjiexu.xyz.compositeIds.QuantityId;
import com.junjiexu.xyz.entities.Quantity;
import com.junjiexu.xyz.entities.Style;
import com.junjiexu.xyz.interfaces.StyleI;

public class StyleDao extends AbstractDao implements StyleI {

	@Override
	public List<Style> getStylesByProductId(int productId) {
		try {
			System.out.println("addProduct");
			System.out.println("productId: " + productId);
			connect();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT s from Style s WHERE s.product.id = :productId", Style.class);
			query.setParameter("productId", productId);
			List<Style> styles = query.getResultList();
			return styles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

	@Override
	public int addStyle(Style style) {
		try {
			System.out.println("addStyle");
			System.out.println("style: " + style);
			connect();
			em.getTransaction().begin();
			em.persist(style);
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
	public Style getStyleById(int id) {
		try {
			System.out.println("getStyleById");
			System.out.println("id: " + id);
			connect();
			return em.find(Style.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

	

}
