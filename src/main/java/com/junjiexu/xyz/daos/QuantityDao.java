package com.junjiexu.xyz.daos;

import com.junjiexu.xyz.compositeIds.QuantityId;
import com.junjiexu.xyz.entities.Quantity;
import com.junjiexu.xyz.interfaces.QuantityI;

public class QuantityDao extends AbstractDao implements QuantityI {

	@Override
	public int getQuantityByStyleIdAndSize(int styleId, String size) {
		try {
			System.out.println("getQuantityByStyleIdAndSize");
			System.out.println("styleId: " + styleId);
			System.out.println("size: " + size);
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
			System.out.println("updateQuantityByStyleIdAndSize");
			System.out.println("styleId: " + styleId);
			System.out.println("size: " + size);
			System.out.println("quantity: " + quantity);
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
			System.out.println("removeQuantityByStyleIdAndSize");
			System.out.println("styleId: " + styleId);
			System.out.println("size: " + size);
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
			System.out.println("addQuantity");
			System.out.println("quantity: " + quantity);
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
