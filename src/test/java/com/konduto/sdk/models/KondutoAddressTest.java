package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoAddressFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by rsampaio on 06/08/14.
 */
public class KondutoAddressTest {
	@Test
	public void serializeTest(){
		String expectedJSON = TestUtils.readJSONFromFile("address.json");
		String actualJSON = null;

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
