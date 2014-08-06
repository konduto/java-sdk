package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoAddressFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by rsampaio on 06/08/14.
 */
public class KondutoAddressTest {
	@Test
	public void serializationWithoutGeolocation(){
		KondutoAddress expectedAddress = KondutoAddressFactory.addressWithoutGeolocation();
		KondutoAddress actualAddress = null;

		try {
			actualAddress = new KondutoAddress(expectedAddress.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("actual address should be valid");
		}

		assertEquals("address serialization should have succeeded", expectedAddress, actualAddress);

	}

	@Test
	public void serializationWithGeolocation() {
		KondutoAddress expectedAddress = KondutoAddressFactory.addressWithGeolocation();
		KondutoAddress actualAddress = null;

		try {
			actualAddress = new KondutoAddress(expectedAddress.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("actual address should be valid");
		}

		assertEquals("address serialization should have succeeded", expectedAddress, actualAddress);

	}

	@Test
	public void serializeGeolocation(){
		KondutoGeolocation geolocation = KondutoAddressFactory.getGeolocation();
		KondutoGeolocation actualGeolocation = null;

		try {
			actualGeolocation = new KondutoGeolocation(geolocation.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("actual geolocation should be valid");
		}

		assertEquals("address serialization should have succeeded", geolocation, actualGeolocation);
	}

}
