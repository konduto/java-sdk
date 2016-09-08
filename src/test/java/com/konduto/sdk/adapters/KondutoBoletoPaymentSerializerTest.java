package com.konduto.sdk.adapters;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.models.KondutoBoletoPayment;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static com.konduto.sdk.factories.KondutoPaymentFactory.getBoletoPayment;
import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoBoletoPaymentSerializerTest {

    @Test
    public void testSerialize() throws Exception {
        KondutoBoletoPayment boletoPayment = getBoletoPayment();
        JsonObject paymentAsJSON = boletoPayment.toJSON();
        SimpleDateFormat boletoDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(paymentAsJSON.get("expiration_date").getAsString(),
                boletoDateFormat.format(boletoPayment.getExpirationDate()));
        assertEquals(paymentAsJSON.get("type").getAsString(), "boleto");
    }

    @Test
    public void testSerializeWithoutExpirationDate() throws KondutoInvalidEntityException {
        JsonObject paymentAsJSON = new KondutoBoletoPayment().toJSON();
        assertEquals(paymentAsJSON.get("type").getAsString(), "boleto");
    }

}