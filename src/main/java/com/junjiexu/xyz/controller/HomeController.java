package com.junjiexu.xyz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junjiexu.xyz.daos.ProductDao;
import com.junjiexu.xyz.entities.Product;
import com.junjiexu.xyz.entities.Style;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String indexHandler() {
		return "index";
	}
	
	@GetMapping("/men")
	public ModelAndView menHandler() {
		ModelAndView mav = new ModelAndView("products");
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getProductsByType("MEN");
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
		mav.addObject("styles", styles);
		return mav;
	}
	
	@GetMapping("/women")
	public ModelAndView womenHandler() {
		ModelAndView mav = new ModelAndView("products");
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getProductsByType("WOMEN");
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
		mav.addObject("styles", styles);
		return mav;
	}
	
	@GetMapping("/product/{styleId}")
	public ModelAndView productHandler(@PathVariable(value="styleId") int styleId) {
		System.out.println("styleId: " + styleId);
		ModelAndView mav = new ModelAndView("product");
		return mav;
	}
}
