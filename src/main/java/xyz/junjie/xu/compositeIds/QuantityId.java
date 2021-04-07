package xyz.junjie.xu.compositeIds;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class QuantityId implements Serializable{
	private int styleId;
	private String size;
	public QuantityId() {
		super();
	}
	public QuantityId(int styleId, String size) {
		super();
		this.styleId = styleId;
		this.size = size;
	}
	
	
	public int getStyleId() {
		return styleId;
	}
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + styleId;
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
		QuantityId other = (QuantityId) obj;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (styleId != other.styleId)
			return false;
		return true;
	}
	
	
}
