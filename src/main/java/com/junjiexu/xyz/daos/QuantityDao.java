package com.junjiexu.xyz.daos;

import com.junjiexu.xyz.compositeIds.QuantityId;
import com.junjiexu.xyz.entities.Quantity;
import com.junjiexu.xyz.interfaces.QuantityI;

public class QuantityDao extends AbstractDao implements QuantityI {

	
	/** 
	 * retrieves stock Quantity of a style
	 * @param styleId id of the style
	 * @param size size of the item
	 * @return Quantity
	 * 
	 * */
	@Override
	public Quantity getQuantityByStyleIdAndSize(int styleId, String size) {
		try {
			System.out.println("getQuantityByStyleIdAndSize");
			System.out.println("styleId: " + styleId);
			System.out.println("size: " + size);
			connect();
			em.getTransaction().begin();
			Quantity q = em.find(Quantity.class, new QuantityId(styleId, size));
			return q;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

	
	/** 
	 * updates stock quantity of item
	 * @param styleId id of item
	 * @param size size of item
	 * @param stockQuantity new stock quantity of item
	 * @return integer specifying a specifying a successful or failed update
	 * 
	 * */
	@Override
	public int updateQuantityByStyleIdAndSize(int styleId, String size, int stockQuantity) {
		try {
			System.out.println("updateQuantityByStyleIdAndSize");
			System.out.println("styleId: " + styleId);
			System.out.println("size: " + size);
			System.out.println("quantity: " + stockQuantity);
			connect();
			em.getTransaction().begin();
			Quantity q = em.find(Quantity.class, new QuantityId(styleId, size));
			q.setStockQuantity(stockQuantity);
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
	 * removes stock quantity of item (indicate that item is no longer in stock)
	 * @param styleId styleId of item
	 * @param size size of item
	 * @return integer specifying a specifying a successful or failed removal
	 * 
	 * */
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

	
	/** 
	 * adds stockQuantity of item
	 * @param quantity quantity of item
	 * @return integer specifying a specifying a successful or failed addition of quantity entity
	 * 
	 * */
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
