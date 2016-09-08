package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoPaymentFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 */
public class KondutoCreditCardPaymentTest {
    KondutoPayment creditCardPayment = KondutoPaymentFactory.getCreditCardPayment();

    @Test
	public void serializeTest(){
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

	@Test
	public void isInvalidWithoutStatusTest() {
		KondutoCreditCardPayment creditCardPayment = new KondutoCreditCardPayment();
		assertFalse(creditCardPayment.isValid());
		creditCardPayment.setStatus(KondutoPaymentStatus.APPROVED);
		assertTrue(creditCardPayment.isValid());
	}

    @Test
    public void typeIsCreditCardTest() {
        assertEquals(KondutoPaymentType.CREDIT, creditCardPayment.getType());
    }
}
