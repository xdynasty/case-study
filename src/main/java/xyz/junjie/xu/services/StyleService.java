package xyz.junjie.xu.services;

import java.util.ArrayList;
import java.util.List;

import xyz.junjie.xu.daos.ProductDao;
import xyz.junjie.xu.entities.Product;
import xyz.junjie.xu.entities.Style;

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
		return styles;
	}
}
