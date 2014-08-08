package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoDeviceFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 */
public class KondutoDeviceTest {
	@Test
	public void serializeTest(){
		KondutoDevice device = KondutoDeviceFactory.getDevice();
		JsonObject deviceJSON = TestUtils.readJSONFromFile("device.json");

		try {
			assertEquals("serialization failed", deviceJSON, device.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("device should be valid");
		}

		assertEquals("deserialization failed", KondutoModel.fromJSON(deviceJSON, KondutoDevice.class), device);

	}
}
