package com.junjiexu.xyz.daos;

import com.junjiexu.xyz.compositeIds.QuantityId;
import com.junjiexu.xyz.entities.Quantity;
import com.junjiexu.xyz.interfaces.QuantityI;

public class QuantityDao extends AbstractDao implements QuantityI {

	@Override
	public int getQuantityByStyleIdAndSize(int styleId, String size) {
		try {
			connect();
			em.getTransaction().begin();
			Quantity q = em.find(Quantity.class, new QuantityId(styleId, size));
			return q.getQuantity();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			disconnect();
		}
	}

	@Override
	public int updateQuantityByStyleIdAndSize(int styleId, String size, int quantity) {
		try {
			connect();
			em.getTransaction().begin();
			Quantity q = em.find(Quantity.class, new QuantityId(styleId, size));
			q.setQuantity(quantity);
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
	public int removeQuantityByStyleIdAndSize(int styleId, String size) {
		try {
			connect();
			em.getTransaction().begin();
			Quantity q = em.find(Quantity.class, new QuantityId(styleId, size));
			em.remove(q);
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
	public int addQuantity(Quantity quantity) {
		try {
			connect();
			em.getTransaction().begin();
			em.persist(quantity);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			disconnect();
		}
	}

}
