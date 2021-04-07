package xyz.junjie.xu.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/** 
 * 
 * Entity Class for Style
 * 
 * */

@Entity
@Table(name="style")
public class Style {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	@Basic
	private String name;
	@Basic
	@Column(name="PREVIEW_IMAGES")
	private String[] previewImages;
	@Basic
	private String[] images;
	@Basic
	private double price;
	@OneToMany(mappedBy="style")
	private List<Quantity> quantities;

	public Style() {
		super();
	}

	
	public Style(int id, Product product, String name, String[] previewImages, String[] images, double price,
			List<Quantity> quantities) {
		super();
		this.id = id;
		this.product = product;
		this.name = name;
		this.previewImages = previewImages;
		this.images = images;
		this.price = price;
		this.quantities = quantities;
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getPreviewImages() {
		return previewImages;
	}


	public void setPreviewImages(String[] previewImages) {
		this.previewImages = previewImages;
	}


	public String[] getImages() {
		return images;
	}


	public void setImages(String[] images) {
		this.images = images;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public List<Quantity> getQuantities() {
		return quantities;
	}


	public void setQuantities(List<Quantity> quantities) {
		this.quantities = quantities;
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
		Style other = (Style) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	

	
}
