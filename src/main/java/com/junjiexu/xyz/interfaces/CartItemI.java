package com.junjiexu.xyz.interfaces;

import java.util.List;

import com.junjiexu.xyz.entities.CartItem;

public interface CartItemI {
	List<CartItem> getAllCartItemsByUserEmail(String userEmail);
	int addCartItem(CartItem ci);
	int removeCartItem(String userEmail, int styleId);
	int updateCartItemCartQuantity(String userEmail, int styleId, int quantity);
}
