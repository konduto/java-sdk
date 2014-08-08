package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoAddressFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 */
public class KondutoAddressTest {
	@Test
	public void serializeTest(){
		JsonObject expectedJSON = TestUtils.readJSONFromFile("address.json");
		JsonObject actualJSON = null;

		KondutoAddress address = KondutoAddressFactory.getAddress();
		try {
			actualJSON = address.toJSON();
		} catch (KondutoInvalidEntityException e) {
			fail("address should be valid");
		}

		assertEquals("address serialization failed", expectedJSON, actualJSON);

		KondutoAddress addressFromJSON = (KondutoAddress) KondutoModel.fromJSON(expectedJSON, KondutoAddress.class);

		assertEquals("address deserialization failed", address, addressFromJSON);
	}
}
