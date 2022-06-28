package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoDeliveryFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 */
public class KondutoDeliveryTest {
	@Test
	public void serializeTest(){
		JsonObject expectedJSON = (JsonObject) TestUtils.readJSONFromFile("delivery.json");
		JsonObject actualJSON = null;

		KondutoDelivery delivery = KondutoDeliveryFactory.getDelivery();
		try {
			actualJSON = delivery.toJSON();
		} catch (KondutoInvalidEntityException e) {
			fail("delivery should be valid");
		}

		assertEquals("delivery serialization failed", expectedJSON, actualJSON);

		KondutoDelivery deliveryFromJSON = (KondutoDelivery) KondutoModel.fromJSON(expectedJSON, KondutoDelivery.class);

		assertEquals("delivery deserialization failed", delivery, deliveryFromJSON);
	}
}
