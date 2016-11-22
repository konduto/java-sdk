package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoHotelFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.fail;

/**
 */
public class KondutoHotelTest {
	@Test
	public void serializeTest() throws ParseException {
		KondutoHotel hotel = KondutoHotelFactory.getHotel();
		JsonObject hotelJSON = (JsonObject) TestUtils.readJSONFromFile("hotel.json");

		try {
			assertEquals("serialization failed", hotelJSON, hotel.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("device should be valid");
		}

		KondutoHotel deserializedHotel = (KondutoHotel) KondutoModel.fromJSON(hotelJSON, KondutoHotel.class);

		assertEquals("deserialization failed", deserializedHotel, hotel);
	}
}
