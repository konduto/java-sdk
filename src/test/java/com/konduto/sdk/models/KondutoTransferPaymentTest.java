package com.konduto.sdk.models;

import com.konduto.sdk.factories.KondutoPaymentFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoTransferPaymentTest {
    private static final KondutoTransferPayment TRANSFER_PAYMENT = KondutoPaymentFactory.getTransferPayment();

    @Test
    public void typeIsDebitTest() {
        assertEquals(KondutoPaymentType.TRANSFER, TRANSFER_PAYMENT.getType());
    }
}
