package xyz.junjie.xu.compositeIds;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class ReviewId implements Serializable {
	
	private int styleId;
	
	private String username;
	
	public ReviewId(int styleId, String username) {
		super();
		this.styleId = styleId;
		this.username = username;
	}
	
	public ReviewId() {
		super();
	}

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + styleId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ReviewId other = (ReviewId) obj;
		if (styleId != other.styleId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
