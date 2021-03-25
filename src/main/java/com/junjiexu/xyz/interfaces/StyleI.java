package com.junjiexu.xyz.interfaces;

import java.util.List;

import com.junjiexu.xyz.entities.Style;

public interface StyleI {
	List<Style> getStylesByProductId(int productId);
}
