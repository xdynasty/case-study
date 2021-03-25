package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.junjiexu.xyz.compositeIds.QuantityId;
import com.junjiexu.xyz.daos.ProductDao;
import com.junjiexu.xyz.daos.QuantityDao;
import com.junjiexu.xyz.daos.StyleDao;
import com.junjiexu.xyz.entities.Product;
import com.junjiexu.xyz.entities.Quantity;
import com.junjiexu.xyz.entities.Style;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xyz");
		EntityManager em = emf.createEntityManager();
		
		ProductDao productDao = new ProductDao();
		productDao.addProduct(new Product(1, "LOGO OVER COTTON & WOOL KNIT SWEATER", "CLOTHING/KNITWEAR", new String[] {"Embroidered front logo", "Model is wearing a size M", "Model height: 1.88m", 
				"Cut for an oversize fit",
				"Buy your usual size",
				"Composition: 71% Cotton, 12% Wool, 17% Polyamide}"}, "MEN"));
		productDao.addProduct(new Product(2, "LOGO PATCH COTTON JERSEY SWEATPANTS", "CLOTHING/PANTS", 
				new String[] {
						"Elastic waistband with drawstring",
				"Elastic cuffs at hem",
				"Embroidered logo patch",
				"Two side pockets",
				"Model is wearing a size M",
				"Model height: 1.88m",
				"Buy your usual size",
				"Composition: 100% Cotton"}, "MEN"));
		productDao.addProduct(new Product(3, "991 SNEAKERS", "SHOES/SNEAKERS", 
				new String[] {
						"Suede, leather and mesh upper",
						"Front lace-up closure",
						"Logo details",
						"Rubber sole",
						"Fit: Buy one size above your usual size",
						"Made in the UK",
						"Composition: Pig"}, "MEN"));
		productDao.addProduct(new Product(4, "GUSSET FLAT LEATHER CROSSBODY BAG", "BAGS/CROSSBODY & MESSENGER BAGS", 
				new String[] {
						"Height: 13cm Width: 17cm Depth: 4cm",
						"Detachable shoulder strap",
						"Front flap closure",
						"Logo details",
						"One back zip pocket",
						"Internal card slots",
						"Composition: 92% Calf, 8% Polyester"}, "MEN"));
		StyleDao styleDao = new StyleDao();
		styleDao.addStyle(new Style(1, productDao.getProductById(1), "NAVY", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/t1.jpeg",
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/t2.jpeg"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/1.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/3.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/1/5.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/6.jpeg"}, 320));
		styleDao.addStyle(new Style(2, productDao.getProductById(2), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/2/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/2/1.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/2/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/5.webp"}, 100));
		styleDao.addStyle(new Style(3, productDao.getProductById(3), "NAVY", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/2/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/3/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/5.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/6.webp"}, 350));
		styleDao.addStyle(new Style(4, productDao.getProductById(3), "GREEN", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/4/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/4/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/4/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/4/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/4/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/4/4.webp"}, 350));
		styleDao.addStyle(new Style(5, productDao.getProductById(4), "COGNAC", 
				new String[] {
						"https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/1.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/2.JPG"
				}, new String[] {
						"https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/1.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/3.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/5.JPG"}, 350));
		QuantityDao quantityDao = new QuantityDao();
		quantityDao.addQuantity(new Quantity(new QuantityId(1, "M"), 4, styleDao.getStyleById(1)));
		quantityDao.addQuantity(new Quantity(new QuantityId(1, "L"), 2, styleDao.getStyleById(1)));
		quantityDao.addQuantity(new Quantity(new QuantityId(1, "S"), 1, styleDao.getStyleById(1)));
		quantityDao.addQuantity(new Quantity(new QuantityId(2, "30"), 3, styleDao.getStyleById(2)));
		quantityDao.addQuantity(new Quantity(new QuantityId(2, "32"), 2, styleDao.getStyleById(2)));
		quantityDao.addQuantity(new Quantity(new QuantityId(2, "34"), 5, styleDao.getStyleById(2)));
		quantityDao.addQuantity(new Quantity(new QuantityId(2, "36"), 6, styleDao.getStyleById(2)));
		quantityDao.addQuantity(new Quantity(new QuantityId(3, "8.5"), 1, styleDao.getStyleById(3)));
		quantityDao.addQuantity(new Quantity(new QuantityId(3, "9.5"), 4, styleDao.getStyleById(3)));
		quantityDao.addQuantity(new Quantity(new QuantityId(3, "7"), 2, styleDao.getStyleById(3)));
		quantityDao.addQuantity(new Quantity(new QuantityId(4, "8.5"), 1, styleDao.getStyleById(4)));
		quantityDao.addQuantity(new Quantity(new QuantityId(4, "9"), 3, styleDao.getStyleById(4)));
		quantityDao.addQuantity(new Quantity(new QuantityId(5, "OS"), 3, styleDao.getStyleById(5)));
	}
}
