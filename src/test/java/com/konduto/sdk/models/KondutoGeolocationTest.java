package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoGeolocationFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by rsampaio on 07/08/14.
 */
public class KondutoGeolocationTest {

	@Test
	public void serializationTest(){
		KondutoGeolocation geolocation = KondutoGeolocationFactory.getGeolocation();
		String geolocationJSON = TestUtils.readJSONFromFile("geolocation.json");
		try {
			assertEquals("serialization failed", geolocationJSON, geolocation.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("geolocation should be valid");
		}

		KondutoGeolocation geolocationDeserialized =
				(KondutoGeolocation) KondutoModel.fromJSON(geolocationJSON, KondutoGeolocation.class);

		assertEquals("deserialization failed", geolocation, geolocationDeserialized);
	}

}
