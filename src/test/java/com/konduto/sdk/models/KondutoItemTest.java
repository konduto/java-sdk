package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoItemFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by rsampaio on 11/08/14.
 */
public class KondutoItemTest {
	KondutoItem greenTShirt = KondutoItemFactory.getGreenTShirt();
	JsonObject greenTShirtJSON =
			(JsonObject) TestUtils.readJSONFromFile("shopping_cart.json").getAsJsonArray().get(0);

	@Test
	public void serializationTest() {
		try {
			assertEquals("serialization failed", greenTShirtJSON, greenTShirt.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("Green T-Shirt should be valid");
		}
	}

	@Test
	public void deserializationtest() {
		assertEquals("deserialization failed", greenTShirt, KondutoModel.fromJSON(greenTShirtJSON, KondutoItem.class));
	}
}
