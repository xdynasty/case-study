package com.junjiexu.xyz.services;

import java.util.ArrayList;
import java.util.List;

import com.junjiexu.xyz.daos.ProductDao;
import com.junjiexu.xyz.entities.Product;
import com.junjiexu.xyz.entities.Style;

public class StyleService {
	public List<Style> getAllStyles(String type) {
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getProductsByType(type);
		List<Style> styles = new ArrayList<>();
		for (Product product : products) {
			for (Style style : product.getStyles()) {
				styles.add(style);
			}
		}
		for (Product product : products) {
			System.out.println(product.getId());
		}
		System.out.println("PRODUCTS SIZE");
		System.out.println(products.size());
		System.out.println("STYLES SIZE");
		System.out.println(styles.size());
		return styles;
	}
}
