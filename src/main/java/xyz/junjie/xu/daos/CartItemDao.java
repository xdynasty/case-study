package xyz.junjie.xu.daos;

import java.util.List;

import javax.persistence.Query;

import xyz.junjie.xu.compositeIds.CartItemId;
import xyz.junjie.xu.entities.CartItem;
import xyz.junjie.xu.interfaces.CartItemI;

public class CartItemDao extends AbstractDao implements CartItemI{

	

	/** 
	 * retrieves all cartItems of user
	 * @param username username of user
	 * @return list of cartItems
	 * 
	 * */
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

	
	/** 
	 * adds cartItem corresponding to user
	 * @param ci cartItem to be added
	 * @return integer specifying a specifying a successful or failed addition
	 * 
	 * */
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

	
	/** 
	 * removes cartItem corresponding to user and styleId
	 * @param username username of user
	 * @param styleId styleId of cartItem
	 * @return integer specifying a specifying a successful or failed removal
	 * 
	 * */
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

	
	/** 
	 * updates cartItem quantity
	 * @param username username of user
	 * @param styleId styleId of cartItem
	 * @param cartQuantity new quantity of cartItem
	 * @return integer specifying a specifying a successful or failed update
	 * 
	 * */
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

	
	/** 
	 * retrieves cartItem corresponding to cartItemId
	 * @param cartItemId id of cartItem
	 * @return CartItem cartItem corresponding to the specified cartItemId
	 * 
	 * */
	@Override
	public CartItem getCartItemByCartItemId(CartItemId cartItemId) {
		try {
			connect();
			return em.find(CartItem.class, cartItemId);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}
	
	
	
}
