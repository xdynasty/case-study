package xyz.junjie.xu.entities;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import xyz.junjie.xu.compositeIds.ReviewId;


@Entity
@Table(name="review")
public class Review {
	@EmbeddedId
	private ReviewId id;
	
	@Basic
	@Column(nullable=false, length=255)
	private String text;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Style style;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATED", updatable=false, insertable=false, nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateCreated;

	public Review() {
		super();
	}

	public Review(ReviewId id, String text, User user, Style style) {
		super();
		this.id = id;
		this.text = text;
		this.user = user;
		this.style = style;
	}


	public ReviewId getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public User getUser() {
		return user;
	}
	
	public Style getStyle() {
		return style;
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
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
