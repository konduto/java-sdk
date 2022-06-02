package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoPointOfSaleFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 */
public class KondutoPointOfSaleTest {

	@Test
	public void isValidTest() {
		KondutoPointOfSale pointOfSale = new KondutoPointOfSale();
		assertFalse("Point of Sale should be invalid without id", pointOfSale.isValid());
		pointOfSale.setId("0001000");
		assertFalse("Point of Sale should be invalid without name", pointOfSale.isValid());
		pointOfSale.setName("Ronaldinho Gaúcho");
		assertTrue("Point of Sale should be valid", pointOfSale.isValid());
	}

	@Test
	public void serializeTest() throws ParseException {
		KondutoPointOfSale pointOfSale = KondutoPointOfSaleFactory.getPointOfSale();
		JsonObject expectedJSON = (JsonObject) TestUtils.readJSONFromFile("point_of_sale.json");

		try {
			assertEquals("Point of Sale serialization failed", expectedJSON, pointOfSale.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("Point of Sale should be valid" + e);
		}

		KondutoPointOfSale pointOfSaleFromJSON = (KondutoPointOfSale) KondutoModel.fromJSON(expectedJSON, KondutoPointOfSale.class);

		assertEquals("Point of Sale deserialization failed", pointOfSale, pointOfSaleFromJSON);
	}

	@Test(expected=KondutoInvalidEntityException.class)
	public void invalidPointOfSaleSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
		KondutoPointOfSale pointOfSale = new KondutoPointOfSale();
		pointOfSale.toJSON(); // triggers invalid customer exception
	}

}
