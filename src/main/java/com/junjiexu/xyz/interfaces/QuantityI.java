package com.junjiexu.xyz.interfaces;

public interface QuantityI {
	int getQuantityByStyleIdAndSize(int styleId, String size);
	int updateQuantityByStyleIdAndSize(int styleId, String size, int quantity);
	int removeQuantityByStyleIdAndSize(int styleId, String size);
}
