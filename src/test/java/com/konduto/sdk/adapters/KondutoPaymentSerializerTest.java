package com.konduto.sdk.adapters;

import com.google.gson.JsonObject;
import com.konduto.sdk.factories.KondutoPaymentFactory;
import com.konduto.sdk.models.KondutoDebitPayment;
import com.konduto.sdk.models.KondutoPayment;
import com.konduto.sdk.models.KondutoTransferPayment;
import com.konduto.sdk.models.KondutoVoucherPayment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoPaymentSerializerTest {
    @Test
    public void serializeTest() throws Exception {
        KondutoDebitPayment debitPayment = KondutoPaymentFactory.getDebitPayment();
        checkPaymentJSON(debitPayment);
        KondutoTransferPayment transferPayment = KondutoPaymentFactory.getTransferPayment();
        checkPaymentJSON(transferPayment);
        KondutoVoucherPayment voucherPayment = KondutoPaymentFactory.getVoucherPayment();
        checkPaymentJSON(voucherPayment);
    }

    private void checkPaymentJSON(KondutoPayment payment) throws Exception {
        JsonObject paymentAsJSON = payment.toJSON();
        assertEquals(paymentAsJSON.get("type").getAsString(), payment.getTypeAsString());
    }
}
