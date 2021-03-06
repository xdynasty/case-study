package xyz.junjie.xu.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/** 
 * 
 * Entity Class for Product
 * 
 * */

@Entity
@Table(name="product")
public class Product {
	@Id
	private int id;
	
	@Basic
	@Column(nullable=false, length=100)
	private String name;
	
	@Basic
	@Column(nullable=false)
	private String category;
	
	@Basic
	@Column(nullable=false)
	private String[] details;
	
	@Basic
	@Column(nullable=false)
	private String type;
	
	@OneToMany(mappedBy="product")
	List<Style> styles;

	public Product() {
		super();
	}

	public Product(int id, String name, String category, String[] details, String type, List<Style> styles) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.details = details;
		this.type = type;
		this.styles = styles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String[] getDetails() {
		return details;
	}

	public void setDetails(String[] details) {
		this.details = details;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Style> getStyles() {
		return styles;
	}

	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
}
