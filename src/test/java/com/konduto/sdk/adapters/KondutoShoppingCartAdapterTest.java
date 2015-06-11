package com.konduto.sdk.adapters;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.factories.KondutoItemFactory;
import com.konduto.sdk.models.KondutoItem;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 11/08/14.
 */
public class KondutoShoppingCartAdapterTest {
	Type shoppingCartType = new TypeToken<Collection<KondutoItem>>(){}.getType();

	Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(shoppingCartType, new KondutoShoppingCartAdapter())
			.setDateFormat("yyyy-MM-dd")
			.create();

	Collection<KondutoItem> shoppingCart = KondutoItemFactory.getShoppingCart();

	JsonArray shoppingCartJSON = (JsonArray) TestUtils.readJSONFromFile("shopping_cart.json");

	@Test
	public void serializeTest(){
		assertEquals("serialization failed", shoppingCartJSON, gson.toJsonTree(shoppingCart));
	}

	@Test
	public void deserializeTest(){
		assertEquals("deserialization failed", shoppingCart, gson.fromJson(shoppingCartJSON, shoppingCartType));
	}


}
