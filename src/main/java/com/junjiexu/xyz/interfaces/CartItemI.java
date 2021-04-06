package com.junjiexu.xyz.interfaces;

import java.util.List;

import com.junjiexu.xyz.compositeIds.CartItemId;
import com.junjiexu.xyz.entities.CartItem;

public interface CartItemI {
	List<CartItem> getAllCartItemsByUsername(String username);
	int addCartItem(CartItem ci);
	int removeCartItem(String username, int styleId);
	int updateCartItemCartQuantity(String userEmail, int styleId, int quantity);
	CartItem getCartItemByCartItemId(CartItemId cartItemId);
}
