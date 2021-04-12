package xyz.junjie.xu.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import xyz.junjie.xu.compositeIds.CartItemId;
import xyz.junjie.xu.daos.CartItemDao;
import xyz.junjie.xu.entities.CartItem;
import xyz.junjie.xu.entities.Product;
import xyz.junjie.xu.entities.Style;
import xyz.junjie.xu.entities.User;

class TestCartItemDao {
	CartItemDao cartItemDao = new CartItemDao();
	@Test
	void testGetAddCartItem() {
		int expected = 1;
		int actual = cartItemDao.addCartItem(new CartItem(new CartItemId("junjie325@gmail.com", 5), "OS", 1, new Style(5, new Product(4, "GUSSET FLAT LEATHER CROSSBODY BAG", "BAGS/CROSSBODY & MESSENGER BAGS", 
				new String[] {
						"Height: 13cm Width: 17cm Depth: 4cm",
						"Detachable shoulder strap",
						"Front flap closure",
						"Logo details",
						"One back zip pocket",
						"Internal card slots",
						"Composition: 92% Calf, 8% Polyester"}, "MEN", null), "COGNAC", 
				new String[] {
						"https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/1.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/2.JPG"
				}, new String[] {
						"https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/1.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/3.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/5.JPG"}, 3250, null, null), new User("junjie325@gmail.com", "pass123", null)));
		Assertions.assertEquals(expected, actual);
	}

}
