package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoItem;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rsampaio on 11/08/14.
 */
public class KondutoItemFactory {

	public static Collection<KondutoItem> getShoppingCart(){
		return Arrays.asList(getGreenTShirt(), getYellowSocks());
	}

	public static KondutoItem getGreenTShirt(){
		KondutoItem greenTShirt = new KondutoItem();
		greenTShirt.setSku("9919023");
		greenTShirt.setProductCode("123456789999");
		greenTShirt.setCategory(201);
		greenTShirt.setName("Green T-Shirt");
		greenTShirt.setDescription("Male Green T-Shirt V Neck");
		greenTShirt.setUnitCost(1999.99);
		greenTShirt.setQuantity(1d);
		return greenTShirt;
	}

	public static KondutoItem getYellowSocks(){
		KondutoItem yellowSocks = new KondutoItem();
		yellowSocks.setSku("0017273");
		yellowSocks.setCategory(202);
		yellowSocks.setName("Yellow Socks");
		yellowSocks.setDescription("Pair of Yellow Socks");
		yellowSocks.setUnitCost(29.9);
		yellowSocks.setQuantity(2d);
		yellowSocks.setDiscount(5.0);
		return yellowSocks;
	}
}
