package com.junjiexu.xyz.daos;

import java.util.List;
import javax.persistence.Query;
import com.junjiexu.xyz.entities.Style;
import com.junjiexu.xyz.interfaces.StyleI;

public class StyleDao extends AbstractDao implements StyleI {

	@Override
	public List<Style> getStylesByProductId(int productId) {
		try {
			connect();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT s from Style s WHERE product_id = :productId", Style.class);
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

}
