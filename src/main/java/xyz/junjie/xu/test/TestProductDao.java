/**
 * 
 */
package xyz.junjie.xu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import xyz.junjie.xu.daos.ProductDao;
import xyz.junjie.xu.entities.Product;

class TestProductDao {
	ProductDao productDao = new ProductDao();
	
	
	@Test
	void testGetProductById() {
		Product expected = new Product(1, "LOGO OVER COTTON & WOOL KNIT SWEATER", "CLOTHING/KNITWEAR", new String[] {"Embroidered front logo", "Model is wearing a size M", "Model height: 1.88m", 
				"Cut for an oversize fit",
				"Buy your usual size",
				"Composition: 71% Cotton, 12% Wool, 17% Polyamide}"}, "MEN", null);
		Product actual = productDao.getProductById(1);
		Assertions.assertEquals(expected, actual);
	}

}
