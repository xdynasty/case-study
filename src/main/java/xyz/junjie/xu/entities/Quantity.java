package xyz.junjie.xu.entities;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import xyz.junjie.xu.compositeIds.QuantityId;



/** 
 * 
 * Entity Class Quantity
 * 
 * */

@Entity
@Table(name="quantity")
public class Quantity {
	@EmbeddedId
	private QuantityId id;
	@Basic
	@JoinColumn(name="STOCK_QUANTITY")
	private int stockQuantity;
	
	@MapsId("styleId")
	@ManyToOne
	private Style style;
	
	public Quantity() {
		super();
	}

	public Quantity(QuantityId id, int stockQuantity, Style style) {
		super();
		this.id = id;
		this.stockQuantity = stockQuantity;
		this.style = style;
	}

	public QuantityId getId() {
		return id;
	}

	public void setId(QuantityId id) {
		this.id = id;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
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
		return true;
	}

	

	

}
