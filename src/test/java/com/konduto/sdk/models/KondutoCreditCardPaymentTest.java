package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoPaymentFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 */
public class KondutoCreditCardPaymentTest {
	@Test
	public void serializeTest(){
		KondutoPayment creditCardPayment = KondutoPaymentFactory.getCreditCardPayment();
		JsonObject creditCardJSON = (JsonObject) TestUtils.readJSONFromFile("payments.json").getAsJsonArray().get(0);
		try {
			assertEquals("serialization failed", creditCardJSON, creditCardPayment.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("credit card payment should be valid");
		}

		KondutoPayment creditCardPaymentDeserialized =
				(KondutoPayment) KondutoModel.fromJSON(creditCardJSON, KondutoCreditCardPayment.class);

		assertEquals("deserialization failed", creditCardPayment, creditCardPaymentDeserialized);
	}
}
