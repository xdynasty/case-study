package xyz.junjie.xu.interfaces;

import java.util.List;

import xyz.junjie.xu.entities.Style;

public interface StyleI {
	List<Style> getStylesByProductId(int productId);
	int addStyle(Style style);
	Style getStyleById(int id);
}
