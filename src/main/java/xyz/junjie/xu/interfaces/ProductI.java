package xyz.junjie.xu.interfaces;

import java.util.List;

import xyz.junjie.xu.entities.Product;

public interface ProductI {
	List<Product> getProductsByType(String type);
	int addProduct(Product product);
	Product getProductById(int id);
}
