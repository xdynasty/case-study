package com.junjiexu.xyz.interfaces;

import java.util.List;

import com.junjiexu.xyz.entities.Product;

public interface ProductI {
	List<Product> getProductsByType(String type);
	int addProduct(Product product);
	Product getProductById(int id);
}
