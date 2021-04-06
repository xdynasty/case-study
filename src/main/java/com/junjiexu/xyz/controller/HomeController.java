package com.junjiexu.xyz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junjiexu.xyz.daos.CartItemDao;
import com.junjiexu.xyz.daos.ProductDao;
import com.junjiexu.xyz.daos.StyleDao;
import com.junjiexu.xyz.daos.UserDao;
import com.junjiexu.xyz.entities.CartItem;
import com.junjiexu.xyz.entities.Product;
import com.junjiexu.xyz.entities.Quantity;
import com.junjiexu.xyz.entities.Style;
import com.junjiexu.xyz.entities.User;
import com.junjiexu.xyz.services.StyleService;

@Controller
public class HomeController {
	@GetMapping("/")
	public String indexHandler() {
		return "index";
	}
	
	
	@GetMapping("/{type}")
	public ModelAndView productsHandler(@PathVariable(value="type") String type) {
		ModelAndView mav = new ModelAndView("products");
		StyleService ss = new StyleService();
		List<Style> styles = ss.getAllStyles(type);
		mav.addObject("styles", styles);
		mav.addObject("type", type.toUpperCase());
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
	public ModelAndView bagHandler(HttpSession session) {
		System.out.println("USER: ");
		System.out.println(session.getAttribute("user"));
		CartItemDao cartItemDao = new CartItemDao();
		List<CartItem> cartItems = cartItemDao.getAllCartItemsByUsername("junjie325@gmail.com");
		for (CartItem ci: cartItems) {
			System.out.println(ci.getStyle().getProduct().getName());
		}
		ModelAndView mav = new ModelAndView("bag");
		mav.addObject("cartItems", cartItems);
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
		System.out.println("username: ");
		System.out.println(user.getUsername());
		System.out.println("password: ");
		System.out.println(user.getPassword());
		UserDao userDao = new UserDao();
		if (userDao.getUserByUsername(user.getUsername()) != null) {
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("message", "ACCOUNT ALREADY EXISTS");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("message", "ACCOUNT CREATED. PLEASE SIGN IN");
			userDao.addUser(user);
			return mav;
		}
	}
	
	@PostMapping("/signin")
	public ModelAndView signinHandler(@ModelAttribute(value="user") User user, HttpSession session) {	
		System.out.println("username: ");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		UserDao userDao = new UserDao();
		if (userDao.getUserByUsername(user.getUsername()) == null) {
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("message", "INVALID CREDENTIALS");
			return mav;
		} else if (!userDao.getUserByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("message", "INVALID CREDENTIALS");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("index");
			session.setAttribute("user", user);
			return mav;
		}
		
	}
	
	@PostMapping("/add_cart_item")
	public void addProductHandler(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("PRINTING REQUEST PARAMETERS");
		System.out.println(request.getParameter("styleId"));
		System.out.println(request.getParameter("size"));	
		response.setStatus(HttpServletResponse.SC_CREATED);
	}
	
	@PostMapping("/update_quantity")
	public void updateQuantityHandler(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("styleId"));
		System.out.println(request.getParameter("newQuantity"));
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
