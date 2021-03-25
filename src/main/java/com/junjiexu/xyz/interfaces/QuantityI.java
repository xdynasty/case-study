package com.junjiexu.xyz.interfaces;

import com.junjiexu.xyz.entities.Quantity;

public interface QuantityI {
	int getQuantityByStyleIdAndSize(int styleId, String size);
	int updateQuantityByStyleIdAndSize(int styleId, String size, int quantity);
	int removeQuantityByStyleIdAndSize(int styleId, String size);
	int addQuantity(Quantity quantity);
}
