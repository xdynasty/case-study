package com.junjiexu.xyz.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.junjiexu.xyz.compositeIds.CartItemId;

@Entity
@Table(name="cart_item")
public class CartItem {
	@EmbeddedId
	private CartItemId id;
	@Basic
	private String size;
	@Basic
	@Column(name="CART_QUANTITY")
	private int cartQuantity;
	@MapsId("styleId")
	@OneToOne
	private Style style;
	@MapsId("userEmail")
	@ManyToOne
	private User user;

	public CartItem() {
		super();
	}

	public CartItem(CartItemId id, String size, int cartQuantity, Style style, User user) {
		super();
		this.id = id;
		this.size = size;
		this.cartQuantity = cartQuantity;
		this.style = style;
		this.user = user;
	}

	public CartItemId getId() {
		return id;
	}

	public void setId(CartItemId id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	

}
