package com.junjiexu.xyz.interfaces;

import com.junjiexu.xyz.entities.Quantity;

public interface QuantityI {
	Quantity getQuantityByStyleIdAndSize(int styleId, String size);
	int updateQuantityByStyleIdAndSize(int styleId, String size, int stockQuantity);
	int removeQuantityByStyleIdAndSize(int styleId, String size);
	int addQuantity(Quantity quantity);
}
