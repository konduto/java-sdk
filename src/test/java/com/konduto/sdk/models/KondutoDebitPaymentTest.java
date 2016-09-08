package com.konduto.sdk.models;

import com.konduto.sdk.factories.KondutoPaymentFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoDebitPaymentTest {
    private static final KondutoDebitPayment DEBIT_PAYMENT = KondutoPaymentFactory.getDebitPayment();

    @Test
    public void typeIsDebitTest() {
        assertEquals(KondutoPaymentType.DEBIT, DEBIT_PAYMENT.getType());
    }
}
