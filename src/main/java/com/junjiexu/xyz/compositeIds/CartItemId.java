package com.junjiexu.xyz.compositeIds;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.junjiexu.xyz.entities.Style;
import com.junjiexu.xyz.entities.User;


@Embeddable
public class CartItemId implements Serializable{
	private String userEmail;
	@Column(name="STYLE_ID")
	private int styleId;
	
	public CartItemId() {
		super();
	}

	public CartItemId(String userEmail, int styleId) {
		super();
		this.userEmail = userEmail;
		this.styleId = styleId;
	}

	public String getuserEmail() {
		return userEmail;
	}

	public void setuserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + styleId;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
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
		CartItemId other = (CartItemId) obj;
		if (styleId != other.styleId)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		return true;
	}

	
	
}
