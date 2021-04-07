package xyz.junjie.xu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import xyz.junjie.xu.compositeIds.QuantityId;
import xyz.junjie.xu.daos.QuantityDao;
import xyz.junjie.xu.entities.Product;
import xyz.junjie.xu.entities.Quantity;
import xyz.junjie.xu.entities.Style;

class TestQuantityDao {
	QuantityDao quantityDao = new QuantityDao();
	
	
	@Test
	void testGetQuantityByStyleIdAndSize() {
		Quantity expected = new Quantity(new QuantityId(1, "M"), 4, new Style(1, new Product(1, "LOGO OVER COTTON & WOOL KNIT SWEATER", "CLOTHING/KNITWEAR", new String[] {"Embroidered front logo", "Model is wearing a size M", "Model height: 1.88m", 
				"Cut for an oversize fit",
				"Buy your usual size",
				"Composition: 71% Cotton, 12% Wool, 17% Polyamide}"}, "MEN", null), "NAVY", 
				new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/t1.jpeg",
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/t2.jpeg"
				}, new String[] {
						"https://case-study.s3.us-east-2.amazonaws.com/images/1/1.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/2.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/3.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/4.webp", "https://case-study.s3.us-east-2.amazonaws.com/images/1/5.jpeg", "https://case-study.s3.us-east-2.amazonaws.com/images/1/6.jpeg"}, 3234.30, null));	
		
		Quantity actual = quantityDao.getQuantityByStyleIdAndSize(1, "M");
		Assertions.assertEquals(expected, actual);
	}

}
