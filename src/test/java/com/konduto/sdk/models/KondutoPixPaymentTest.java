package com.konduto.sdk.models;

import com.konduto.sdk.factories.KondutoPaymentFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoPixPaymentTest {
    private static final KondutoPixPayment PIX_PAYMENT = KondutoPaymentFactory.getPixPayment();

    @Test
    public void typeIsPixTest() {
        assertEquals(KondutoPaymentType.PIX, PIX_PAYMENT.getType());
    }
}
