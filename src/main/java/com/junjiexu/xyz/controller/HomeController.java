package com.junjiexu.xyz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junjiexu.xyz.daos.CartItemDao;
import com.junjiexu.xyz.daos.ProductDao;
import com.junjiexu.xyz.daos.StyleDao;
import com.junjiexu.xyz.entities.Product;
import com.junjiexu.xyz.entities.Quantity;
import com.junjiexu.xyz.entities.Style;
import com.junjiexu.xyz.entities.User;

@Controller
public class HomeController {
	@GetMapping("/")
	public String indexHandler() {
		return "index";
	}
	
	
	@GetMapping("/{type}")
	public ModelAndView typeHandler(@PathVariable(value="type") String type) {
		ModelAndView mav = new ModelAndView("products");
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
		mav.addObject("styles", styles);
		return mav;
	}
	
	@GetMapping("/product/{styleId}")
	public ModelAndView productHandler(@PathVariable(value="styleId") int styleId) {
		StyleDao styleDao = new StyleDao();
		Style style = styleDao.getStyleById(styleId);
		Product product = style.getProduct();
		System.out.println(product.getName());
		ModelAndView mav = new ModelAndView("product");
		System.out.println("PRINTING SIZES");
		List<Quantity> quantities = style.getQuantities();
		System.out.println("PRINTING QUANTITY SIZE");
		System.out.println(quantities.size());
		for (Quantity quantity : quantities) {
			System.out.println(quantity.getId().getSize());
		}
		System.out.println("DONE");
		mav.addObject("style", style);
		return mav;
	}
	
	@GetMapping("/bag")
	public ModelAndView bagHandler() {
		CartItemDao cartItemDao = new CartItemDao();
		cartItemDao.getAllCartItemsByUserEmail(null);
		ModelAndView mav = new ModelAndView("bag");
		return mav;
	}
	
	@GetMapping("/checkout")
	public ModelAndView checkoutHandler() {
		ModelAndView mav = new ModelAndView("checkout");
		return mav;
	}
	
	@GetMapping("/account")
	public ModelAndView accountHandler() {
		ModelAndView mav = new ModelAndView("account");
		return mav;
	}
	
	@PostMapping("/register")
	public ModelAndView registerHandler(@ModelAttribute(value="user") User user) {
		ModelAndView mav = new ModelAndView("index");
		System.out.println("EMAIL: ");
		System.out.println(user.getEmail());
		return mav;
	}
}
