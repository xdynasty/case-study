package xyz.junjie.xu.interfaces;

import java.util.List;

import xyz.junjie.xu.compositeIds.CartItemId;
import xyz.junjie.xu.entities.CartItem;

public interface CartItemI {
	List<CartItem> getAllCartItemsByUsername(String username);
	int addCartItem(CartItem ci);
	int removeCartItem(String username, int styleId);
	int updateCartItemCartQuantity(String userEmail, int styleId, int quantity);
	CartItem getCartItemByCartItemId(CartItemId cartItemId);
}
