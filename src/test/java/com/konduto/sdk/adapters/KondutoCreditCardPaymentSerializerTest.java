package com.konduto.sdk.adapters;

import com.google.gson.JsonObject;
import com.konduto.sdk.factories.KondutoPaymentFactory;
import com.konduto.sdk.models.KondutoCreditCardPayment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoCreditCardPaymentSerializerTest {
    KondutoCreditCardPayment creditCardPayment = KondutoPaymentFactory.getCreditCardPayment();

    @Test
    public void testSerialize() throws Exception {
        JsonObject paymentAsJSON = creditCardPayment.toJSON();
        assertEquals(paymentAsJSON.get("bin").getAsString(), creditCardPayment.getBin());
        assertEquals(paymentAsJSON.get("last4").getAsString(), creditCardPayment.getLast4());
        assertEquals(paymentAsJSON.get("expiration_date").getAsString(), creditCardPayment.getExpirationDate());
        assertEquals(paymentAsJSON.get("status").getAsString(), creditCardPayment.getStatus().toString().toLowerCase());
        assertEquals(paymentAsJSON.get("type").getAsString(), "credit");
    }

    @Test
    public void testSerializeWithoutBin() throws Exception {
        testSerializeWithout("bin");
    }

    @Test
    public void testSerializeWithoutLast4() throws Exception {
        testSerializeWithout("last4");
    }

    @Test
    public void testSerializeWithoutExpirationDate() throws Exception {
        testSerializeWithout("expirationDate");
    }

    private void testSerializeWithout(String attribute) throws Exception {
        creditCardPayment.with(attribute, null);
        JsonObject paymentAsJSON = creditCardPayment.toJSON();
        assertNull(paymentAsJSON.get(attribute));
    }
}