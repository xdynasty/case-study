package xyz.junjie.xu.services;

import xyz.junjie.xu.compositeIds.CartItemId;
import xyz.junjie.xu.daos.CartItemDao;
import xyz.junjie.xu.daos.QuantityDao;
import xyz.junjie.xu.daos.StyleDao;
import xyz.junjie.xu.entities.CartItem;
import xyz.junjie.xu.entities.User;

public class CartItemService {
	public void updateQuantity(String username, int styleId, int newQuantity) {
		CartItemDao cartItemDao = new CartItemDao();
		if (newQuantity > 0) {
			cartItemDao.updateCartItemCartQuantity(username, styleId, newQuantity);
		} else {
			cartItemDao.removeCartItem(username, styleId);
		}	 
	}
	
	public int addCartItem(User user, int styleId, String size) {
		CartItemDao cartItemDao = new CartItemDao();
		StyleDao styleDao = new StyleDao();
		QuantityDao quantityDao = new QuantityDao();
		CartItemId cartItemId = new CartItemId(user.getUsername(), styleId);
		CartItem ci = cartItemDao.getCartItemByCartItemId(cartItemId);
		if (ci != null && quantityDao.getQuantityByStyleIdAndSize(styleId, size)
				.getStockQuantity() >= ci.getCartQuantity() + 1) {
			cartItemDao.updateCartItemCartQuantity(user.getUsername(), styleId, ci.getCartQuantity() + 1);
			return 1;
		} else if (ci != null && quantityDao.getQuantityByStyleIdAndSize(styleId, size)
				.getStockQuantity() < ci.getCartQuantity() + 1) {
			return 0;
		} else {
			cartItemDao.addCartItem(new CartItem(new CartItemId(user.getUsername(), styleId), size, 1,
					styleDao.getStyleById(styleId), user));
			return 1;
		}
	}
}
