package com.junjiexu.xyz.entities;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.junjiexu.xyz.compositeIds.QuantityId;

@Entity
@Table(name="quantity")
public class Quantity {
	@EmbeddedId
	private QuantityId id;
	@Basic
	private int quantity;
	
	@MapsId("styleId")
	@ManyToOne
	private Style style;
	
	public Quantity() {
		super();
	}

	public Quantity(QuantityId id, int quantity, Style style) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.style = style;
	}

	public QuantityId getId() {
		return id;
	}

	public void setId(QuantityId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((style == null) ? 0 : style.hashCode());
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
		Quantity other = (Quantity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity != other.quantity)
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		return true;
	}

	

}
