package com.junjiexu.xyz.daos;

import java.util.List;

import javax.persistence.Query;

import com.junjiexu.xyz.compositeIds.CartItemId;
import com.junjiexu.xyz.entities.CartItem;
import com.junjiexu.xyz.interfaces.CartItemI;

public class CartItemDao extends AbstractDao implements CartItemI{

	@Override
	public List<CartItem> getAllCartItemsByUsername(String username) {
		try {
			System.out.println("getAllCartItemsByUserEmail");
			System.out.println("username: " + username);
			connect();
			Query query = em.createQuery("SELECT ci from CartItem ci WHERE ci.id.username = :username");
			query.setParameter("username", username);
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
	public int removeCartItem(String username, int styleId) {
		try {
			System.out.println("removeCartItem");
			System.out.println("username: " + username);
			System.out.println("styleId: " + styleId);
			connect();
			em.getTransaction().begin();
			CartItem ci = em.find(CartItem.class, new CartItemId(username, styleId));
			System.out.println("REMOVING");
			System.out.println(ci.getCartQuantity());
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
	public int updateCartItemCartQuantity(String username, int styleId, int cartQuantity) {
		
		try {
			System.out.println("updateCartItemQuantity");
			System.out.println("username: " + username);
			System.out.println("styleId: " + styleId);
			System.out.println("quantity: " + cartQuantity);
			connect();
			em.getTransaction().begin();
			CartItem ci = em.find(CartItem.class, new CartItemId(username, styleId));
			System.out.println(ci.getCartQuantity());
			ci.setCartQuantity(cartQuantity);
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
