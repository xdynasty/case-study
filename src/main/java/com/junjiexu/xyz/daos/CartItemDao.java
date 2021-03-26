package com.junjiexu.xyz.daos;

import java.util.List;

import javax.persistence.Query;

import com.junjiexu.xyz.compositeIds.CartItemId;
import com.junjiexu.xyz.entities.CartItem;
import com.junjiexu.xyz.interfaces.CartItemI;

public class CartItemDao extends AbstractDao implements CartItemI{

	@Override
	public List<CartItem> getAllCartItemsByUserId(String userId) {
		try {
			System.out.println("getAllCartItemsByUserId");
			System.out.println("userId: " + userId);
			connect();
			Query query = em.createQuery("SELECT ci from CartItem ci");
			List<CartItem> cartItems = query.getResultList();
			return cartItems;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

	@Override
	public int addCartItem(CartItem ci) {
		try {
			System.out.println("addCartItem");
			System.out.println("CartItem: " + ci);
			connect();
			em.getTransaction().begin();
			em.persist(ci);
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
	public int removeCartItem(String userEmail, int styleId) {
		try {
			System.out.println("removeCartItem");
			System.out.println("userEmail: " + userEmail);
			System.out.println("styleId: " + styleId);
			connect();
			em.getTransaction().begin();
			CartItem ci = em.find(CartItem.class, new CartItemId(userEmail, styleId));
			System.out.println("REMOVING");
			System.out.println(ci.getQuantity());
			em.remove(ci);
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
	public int updateCartItemQuantity(String userEmail, int styleId, int quantity) {
		
		try {
			System.out.println("updateCartItemQuantity");
			System.out.println("userEmail: " + userEmail);
			System.out.println("styleId: " + styleId);
			System.out.println("quantity: " + quantity);
			connect();
			em.getTransaction().begin();
			CartItem ci = em.find(CartItem.class, new CartItemId(userEmail, styleId));
			System.out.println("REMOVING");
			
			System.out.println(ci.getQuantity());
			ci.setQuantity(quantity);
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
