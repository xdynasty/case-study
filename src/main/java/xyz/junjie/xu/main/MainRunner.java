package xyz.junjie.xu.main;

import xyz.junjie.xu.compositeIds.CartItemId;
import xyz.junjie.xu.compositeIds.QuantityId;
import xyz.junjie.xu.daos.CartItemDao;
import xyz.junjie.xu.daos.ProductDao;
import xyz.junjie.xu.daos.QuantityDao;
import xyz.junjie.xu.daos.StyleDao;
import xyz.junjie.xu.daos.UserDao;
import xyz.junjie.xu.entities.CartItem;
import xyz.junjie.xu.entities.Product;
import xyz.junjie.xu.entities.Quantity;
import xyz.junjie.xu.entities.Style;
import xyz.junjie.xu.entities.User;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		ProductDao productDao = new ProductDao();
//		productDao.getProductsByType("MEN");
//		QuantityDao quantityDao = new QuantityDao();
//		quantityDao.updateQuantityByStyleIdAndSize(2, "30", 4);
		populateTable();
//		StyleDao styleDao = new StyleDao();
//		styleDao.getStylesByProductId(3).forEach(style -> System.out.println(style.getName()));
	}
	
	
	public static void populateTable() {
		
		
		ProductDao productDao = new ProductDao();
		productDao.addProduct(new Product(1, "LOGO OVER COTTON & WOOL KNIT SWEATER", "CLOTHING/KNITWEAR", new String[] {"Embroidered front logo", "Model is wearing a size M", "Model height: 1.88m", 
				"Cut for an oversize fit",
				"Buy your usual size",
				"Composition: 71% Cotton, 12% Wool, 17% Polyamide}"}, "MEN", null));
		productDao.addProduct(new Product(2, "LOGO PATCH COTTON JERSEY SWEATPANTS", "CLOTHING/PANTS", 
				new String[] {
						"Elastic waistband with drawstring",
				"Elastic cuffs at hem",
				"Embroidered logo patch",
				"Two side pockets",
				"Model is wearing a size M",
				"Model height: 1.88m",
				"Buy your usual size",
				"Composition: 100% Cotton"}, "MEN", null));
		productDao.addProduct(new Product(3, "991 SNEAKERS", "SHOES/SNEAKERS", 
				new String[] {
						"Suede, leather and mesh upper",
						"Front lace-up closure",
						"Logo details",
						"Rubber sole",
						"Fit: Buy one size above your usual size",
						"Made in the UK",
						"Composition: Pig"}, "MEN", null));
		productDao.addProduct(new Product(4, "GUSSET FLAT LEATHER CROSSBODY BAG", "BAGS/CROSSBODY & MESSENGER BAGS", 
				new String[] {
						"Height: 13cm Width: 17cm Depth: 4cm",
						"Detachable shoulder strap",
						"Front flap closure",
						"Logo details",
						"One back zip pocket",
						"Internal card slots",
						"Composition: 92% Calf, 8% Polyester"}, "MEN", null));
		productDao.addProduct(new Product(5, "Y-3 CLASSIC NYLON BUCKET HAT", "ACCESSORIES/HATS", 
				new String[] {
						"Front logo","Composition: 100% Polyester"}, "MEN", null));
		productDao.addProduct(new Product(6, "DB ROUND ACETATE OPTICAL GLASSES", "ACCESSORIES/EYEWEAR", 
				new String[] {
						"Lens: 40mm Bridge: 22mm Temple: 145mm",
						"Black acetate frame",
						"Clear lenses",
						"DB logo at the end of the tips",
						"International fitting",
						"Arrive with temporary lenses, that must be removed before use",
						"Composition: Acetate"}, "MEN", null));
		productDao.addProduct(new Product(7, "BIRD BASEBALL HAT", "ACCESSORIES/HATS", 
				new String[] {
						"Adjustable strap at back",
						"Front logo detail",
						"Composition: 62% Cotton, 38% Polyeste"}, "MEN", null));
		productDao.addProduct(new Product(8, "LEATHER TRAVELER GYM BAG", "BAGS/BACKPACKS", 
				new String[] {
						"Height: 20cm Width: 43cm Depth: 26cm",
						"Adjustable shoulder strap",
						"Double top handles",
						"Side handle",
						"Zip closure",
						"One front zip pocket",
						"One internal zip pocket",
						"Lined",
						"Made in Italy",
						"Composition:",
						"Main: 100% Lamb",
						"Lining: 100% Cotton"}, "MEN", null));
		productDao.addProduct(new Product(9, "MILITARY LEATHER BACKPACK", "BAGS/BACKPACKS", 
				new String[] {
					"Height: 39cm Width: 28.5cm Depth: 11cm",
					"Double adjustable webbing shoulder straps with leather reinforcements",
					"Single top handle",
					"Double zip closure",
					"Front flap with magnetic closure",
					"Front adjustable buckle straps",
					"One internal laptop compartment",
					"Composition:",
					"Main 1: Calf",
					"Main 2: Cotton",
					"Main 3: Polyester"}, "MEN", null));
		productDao.addProduct(new Product(10, "IVY LINEN & SILK BOMBER JACKET", "CLOTHING/JACKETS", 
				new String[] {
					"Front zip closure",
					"Ribbed collar, cuffs and hem",
					"Two side pockets",
					"Lined",
					"Model is wearing a size M",
					"Model height: 1.88m",
					"Buy your usual size",
					"Made in Italy",
					"Composition:",
					"Main: 59% Linen, 41% Silk",
					"Lining: Polyester"}, "MEN", null));
		productDao.addProduct(new Product(11, "TICKET PRINTED COTTON T-SHIRT", "CLOTHING/T-SHIRTS", 
				new String[] {
						"Crewneck",
						"Printed front panel",
						"Buy your usual size",
						"Made in Italy",
						"Composition: 100% Cotton"}, "MEN", null));
		productDao.addProduct(new Product(12, "TONIGHT PRINT COTTON T-SHIRT", "CLOTHING/T-SHIRTS", 
				new String[] {
						"Printed front panel",
						"Model is wearing a size M",
						"Model height: 1.88m",
						"Buy your usual size",
						"Composition: 100% Cotton"}, "MEN", null));
		productDao.addProduct(new Product(13, "PRINT SNOPPY NIGHT COTTON JERSEY T-SHIRT", "CLOTHING/T-SHIRTS", 
				new String[] {
						"Printed front panel",
						"Buy your usual size",
						"Composition: 100% Cotton"}, "MEN", null));
		productDao.addProduct(new Product(14, "STRIPED VISCOSE JERSEY T-SHIRT", "CLOTHING/T-SHIRTS", 
				new String[] {
						"All over print placement may vary",
						"Model is wearing a size S",
						"Model height: 1.78m",
						"Buy one size above your usual size",
						"Made in Italy",
						"Composition: 100% Viscose"}, "WOMEN", null));
		productDao.addProduct(new Product(15, "LOGO PRINT COTTON BLEND DENIM JACKET", "CLOTHING/JACKETS", 
				new String[] {
						"Front button closure",
						"Button cuffs",
						"All over print placement may vary",
						"Adjustable button tabs at hem",
						"Two breast button flap pockets",
						"Model is wearing a size 36",
						"Model height: 1.78m",
						"Buy your usual size",
						"Made in Italy",
						"Composition: 100% Cotton"}, "WOMEN", null));
		productDao.addProduct(new Product(16, "COTTON JERSEY T-SHIRT W/RUFFLED SLEEVES", "CLOTHING/T-SHIRTS", 
						new String[] {"new StrUnlined",
						"Model is wearing a size 40",
						"Model height: 1.78m",
						"Buy your usual size",
						"Made in Italy",
						"Composition: 100% Cotton"}, "WOMEN", null));
		productDao.addProduct(new Product(17, "TIOMAN CASHMERE KNIT WIDE PANTS", "CLOTHING/PANTS", 
				new String[] {
					"Elastic waistband",
					"Two side pockets",
					"Unlined",
					"Model is wearing a size S",
					"Model height: 1.78m",
					"Buy your usual size",
					"Composition: 100% Cashmere"}, "WOMEN", null));
		
		StyleDao styleDao = new StyleDao();
		styleDao.addStyle(new Style(1, productDao.getProductById(1), "NAVY", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/t1.jpeg",
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/t2.jpeg"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/1.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/3.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/1/5.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/6.jpeg"}, 3234.30, null));
		styleDao.addStyle(new Style(2, productDao.getProductById(2), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/2/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/2/1.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/2/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/2/5.webp"}, 100, null));
		styleDao.addStyle(new Style(3, productDao.getProductById(3), "NAVY", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/3/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/3/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/5.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/3/6.webp"}, 3355.50, null));
		styleDao.addStyle(new Style(4, productDao.getProductById(3), "GREEN", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/4/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/4/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/4/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/4/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/4/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/4/4.webp"}, 332.50, null));
		styleDao.addStyle(new Style(5, productDao.getProductById(4), "COGNAC", 
				new String[] {
						"https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/1.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/2.JPG"
				}, new String[] {
						"https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/1.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/3.JPG", "https://xyz-images-bucket.s3.us-east-2.amazonaws.com/1/5.JPG"}, 3250, null));
		styleDao.addStyle(new Style(6, productDao.getProductById(5), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/6/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/6/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/6/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/6/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/6/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/6/4.webp"}, 254.50, null));
		styleDao.addStyle(new Style(7, productDao.getProductById(6), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/7/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/7/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/7/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/7/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/7/3.webp"}, 23.40, null));
		styleDao.addStyle(new Style(8, productDao.getProductById(7), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/8/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/8/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/8/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/8/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/8/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/8/4.webp"}, 350.45, null));
		styleDao.addStyle(new Style(9, productDao.getProductById(8), "PALM", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/9/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/9/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/9/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/9/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/9/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/9/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/9/5.webp"}, 20.23, null));
		styleDao.addStyle(new Style(10, productDao.getProductById(9), "COGNAC", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/10/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/10/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/10/1.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/10/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/10/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/10/4.webp"}, 332.42, null));
		styleDao.addStyle(new Style(11, productDao.getProductById(9), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/11/t1.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/11/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/11/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/11/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/11/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/11/4.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/11/5.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/11/6.webp"}, 354.34, null));
		styleDao.addStyle(new Style(12, productDao.getProductById(10), "DEEP SEA BLUE", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/12/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/12/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/12/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/12/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/12/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/12/4.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/12/5.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/12/6.webp"}, 35.30, null));
		styleDao.addStyle(new Style(13, productDao.getProductById(11), "WHITE", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/13/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/13/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/13/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/13/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/13/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/13/4.webp"}, 4350.34, null));
		styleDao.addStyle(new Style(14, productDao.getProductById(11), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/14/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/14/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/14/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/14/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/14/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/14/4.webp"}, 310.32, null));
		styleDao.addStyle(new Style(15, productDao.getProductById(12), "WHITE", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/15/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/15/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/15/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/15/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/15/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/15/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/15/5.webp"}, 350.87, null));
		styleDao.addStyle(new Style(16, productDao.getProductById(13), "NAVY", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/16/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/16/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/16/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/16/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/16/3.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/16/4.jpeg"}, 350.32, null));
		styleDao.addStyle(new Style(17, productDao.getProductById(14), "GREY/BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/17/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/17/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/17/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/17/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/17/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/17/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/17/5.webp"}, 350.46, null));
		styleDao.addStyle(new Style(18, productDao.getProductById(15), "STONEWASH", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/18/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/18/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/18/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/18/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/18/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/18/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/18/5.webp"}, 832.87, null));
		styleDao.addStyle(new Style(19, productDao.getProductById(16), "WHITE", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/19/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/19/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/19/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/19/2.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/19/3.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/19/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/19/5.webp"}, 325.53, null));
		styleDao.addStyle(new Style(20, productDao.getProductById(17), "BEIGE", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/20/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/20/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/20/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/20/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/20/3.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/20/4.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/20/5.webp"}, 545.43, null));
		styleDao.addStyle(new Style(21, productDao.getProductById(17), "BLACK", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/21/t1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/21/t2.webp"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/21/1.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/21/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/21/3.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/21/4.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/21/5.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/21/6.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/21/7.webp"}, 150.23, null));
		
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
		quantityDao.addQuantity(new Quantity(new QuantityId(6, "OS"), 3, styleDao.getStyleById(6)));
		quantityDao.addQuantity(new Quantity(new QuantityId(7, "OS"), 3, styleDao.getStyleById(7)));
		quantityDao.addQuantity(new Quantity(new QuantityId(8, "OS"), 3, styleDao.getStyleById(8)));
		quantityDao.addQuantity(new Quantity(new QuantityId(9, "OS"), 3, styleDao.getStyleById(9)));
		quantityDao.addQuantity(new Quantity(new QuantityId(10, "OS"), 3, styleDao.getStyleById(10)));
		quantityDao.addQuantity(new Quantity(new QuantityId(11, "OS"), 3, styleDao.getStyleById(11)));
		quantityDao.addQuantity(new Quantity(new QuantityId(12, "S"), 3, styleDao.getStyleById(12)));
		quantityDao.addQuantity(new Quantity(new QuantityId(12, "M"), 3, styleDao.getStyleById(12)));
		quantityDao.addQuantity(new Quantity(new QuantityId(12, "L"), 1, styleDao.getStyleById(12)));
		quantityDao.addQuantity(new Quantity(new QuantityId(13, "M"), 2, styleDao.getStyleById(13)));
		quantityDao.addQuantity(new Quantity(new QuantityId(14, "L"), 5, styleDao.getStyleById(14)));
		quantityDao.addQuantity(new Quantity(new QuantityId(15, "S"), 6, styleDao.getStyleById(15)));
		quantityDao.addQuantity(new Quantity(new QuantityId(15, "L"), 7, styleDao.getStyleById(15)));
		quantityDao.addQuantity(new Quantity(new QuantityId(16, "S"), 2, styleDao.getStyleById(16)));
		quantityDao.addQuantity(new Quantity(new QuantityId(17, "0"), 3, styleDao.getStyleById(17)));
		quantityDao.addQuantity(new Quantity(new QuantityId(17, "1"), 3, styleDao.getStyleById(17)));
		quantityDao.addQuantity(new Quantity(new QuantityId(17, "2"), 4, styleDao.getStyleById(17)));
		quantityDao.addQuantity(new Quantity(new QuantityId(18, "XS"), 5, styleDao.getStyleById(18)));
		quantityDao.addQuantity(new Quantity(new QuantityId(18, "S"), 3, styleDao.getStyleById(18)));
		quantityDao.addQuantity(new Quantity(new QuantityId(19, "M"), 13, styleDao.getStyleById(19)));
		quantityDao.addQuantity(new Quantity(new QuantityId(19, "L"), 2, styleDao.getStyleById(19)));
		quantityDao.addQuantity(new Quantity(new QuantityId(20, "S"), 1, styleDao.getStyleById(20)));
		quantityDao.addQuantity(new Quantity(new QuantityId(21, "L"), 3, styleDao.getStyleById(20)));
		
		
		UserDao userDao = new UserDao();
		userDao.addUser(new User("junjie325@gmail.com", "pass123", null));
//		CartItemDao cartItemDao = new CartItemDao();
//		 cartItemDao.addCartItem(new CartItem(new CartItemId("junjie325@gmail.com", 3), "8.5", 1, styleDao.getStyleById(3), userDao.getUser("junjie325@gmail.com"), quantityDao.getQuantityByStyleIdAndSize(3, "8.5")));
//		 cartItemDao.addCartItem(new CartItem(new CartItemId("junjie325@gmail.com", 5), "OS", 1, styleDao.getStyleById(5), userDao.getUser("junjie325@gmail.com"), quantityDao.getQuantityByStyleIdAndSize(5, "OS")));
//		cartItemDao.addCartItem(new CartItem(new CartItemId("junjie325@gmail.com", 3), "8.5", 1, styleDao.getStyleById(3), userDao.getUserByUsername("junjie325@gmail.com")));
//		cartItemDao.addCartItem(new CartItem(new CartItemId("junjie325@gmail.com", 5), "OS", 1, styleDao.getStyleById(5), userDao.getUserByUsername("junjie325@gmail.com")));
	}
}
