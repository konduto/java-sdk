package com.konduto.sdk.models;

import com.konduto.sdk.factories.KondutoPaymentFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoTEDPaymentTest {
    private static final KondutoTEDPayment TED_PAYMENT = KondutoPaymentFactory.getTEDPayment();

    @Test
    public void typeIsTEDTest() {
        assertEquals(KondutoPaymentType.TED, TED_PAYMENT.getType());
    }
}
