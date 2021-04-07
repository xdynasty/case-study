package xyz.junjie.xu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import at.favre.lib.crypto.bcrypt.BCrypt;
import xyz.junjie.xu.compositeIds.CartItemId;
import xyz.junjie.xu.daos.CartItemDao;
import xyz.junjie.xu.daos.QuantityDao;
import xyz.junjie.xu.daos.StyleDao;
import xyz.junjie.xu.daos.UserDao;
import xyz.junjie.xu.entities.CartItem;
import xyz.junjie.xu.entities.Style;
import xyz.junjie.xu.entities.User;
import xyz.junjie.xu.services.StyleService;
import xyz.junjie.xu.services.UserService;

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
		ModelAndView mav = new ModelAndView("product");
		mav.addObject("style", style);
		return mav;
	}
	
	@GetMapping("/bag")
	public ModelAndView bagHandler(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("account");
		} else {
			CartItemDao cartItemDao = new CartItemDao();
			List<CartItem> cartItems = cartItemDao.getAllCartItemsByUsername(user.getUsername());
			ModelAndView mav = new ModelAndView("bag");
			mav.addObject("cartItems", cartItems);
			return mav;
		}
	}
	
	@GetMapping("/checkout")
	public ModelAndView checkoutHandler(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("account");
		} else {
			CartItemDao cartItemDao = new CartItemDao();
			List<CartItem> cartItems = cartItemDao.getAllCartItemsByUsername(user.getUsername());
			ModelAndView mav = new ModelAndView("checkout");
			mav.addObject("cartItems", cartItems);
			return mav;
		}
	}
	
	@GetMapping("/account")
	public ModelAndView accountHandler() {
		ModelAndView mav = new ModelAndView("account");
		return mav;
	}
	
	@PostMapping("/register")
	public ModelAndView registerHandler(@ModelAttribute(value="user") User user) {
		UserDao userDao = new UserDao();
		if (userDao.getUserByUsername(user.getUsername()) != null) {
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("message", "ACCOUNT ALREADY EXISTS");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("message", "ACCOUNT CREATED. PLEASE SIGN IN");
			UserService us = new UserService();
			us.registerUser(user);
			return mav;
		}
	}
	
	
	@PostMapping("/signin")
	public ModelAndView signinHandler(@ModelAttribute(value="user") User user, HttpSession session, HttpServletResponse response) {	
		UserDao userDao = new UserDao();
		// if the username (user) does not exist or the password does not match the db record
		if (userDao.getUserByUsername(user.getUsername()) == null || !BCrypt.verifyer().verify(user.getPassword().toCharArray(), userDao.getUserByUsername(user.getUsername()).getPassword()).verified) {
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("message", "INVALID CREDENTIALS");
			return mav;
		} else { //if the user credentials match
			Cookie cookie = new Cookie("sid", user.getUsername());
			cookie.setMaxAge(7 * 24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie); // tell client to set a cookie containing the sessionId
			ModelAndView mav = new ModelAndView("index");
			session.setAttribute("user", user); // store the user reference in the session
			return mav;
		}
	}
	
	@PostMapping("/add_cart_item")
	public void addProductHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		User user = null;
		if (session.getAttribute("user") != null) {
			user = (User) session.getAttribute("user");
		}
		int styleId = Integer.parseInt(request.getParameter("styleId"));
		String size = request.getParameter("size");
		CartItemDao cartItemDao = new CartItemDao();
		StyleDao styleDao = new StyleDao();
		QuantityDao quantityDao = new QuantityDao();
		CartItemId cartItemId = new CartItemId(user.getUsername(), styleId);
		CartItem ci = cartItemDao.getCartItemByCartItemId(cartItemId);
		if (user != null) {
			if (ci != null && quantityDao.getQuantityByStyleIdAndSize(styleId, size).getStockQuantity() >= ci.getCartQuantity() + 1) {
				cartItemDao.updateCartItemCartQuantity(user.getUsername(), styleId, ci.getCartQuantity() + 1);
				response.setStatus(HttpServletResponse.SC_CREATED);
			} else if (ci != null && quantityDao.getQuantityByStyleIdAndSize(styleId, size).getStockQuantity() < ci.getCartQuantity() + 1) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			} else {
				cartItemDao.addCartItem(new CartItem(new CartItemId(user.getUsername(), styleId), size, 1, styleDao.getStyleById(styleId), user));
				response.setStatus(HttpServletResponse.SC_CREATED);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		
	}
	
	@PostMapping("/update_quantity")
	public void updateQuantityHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String username = user.getUsername();
		int styleId = Integer.parseInt(request.getParameter("styleId"));
		int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
		CartItemDao cartItemDao = new CartItemDao();
		if (newQuantity > 0) {
			cartItemDao.updateCartItemCartQuantity(username, styleId, newQuantity);
		} else {
			cartItemDao.removeCartItem(username, styleId);
		}	 
		response.setStatus(HttpServletResponse.SC_OK);
	}
}