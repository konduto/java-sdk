package com.konduto.sdk.models;

import com.konduto.sdk.factories.KondutoPaymentFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoVoucherPaymentTest {
    private static final KondutoVoucherPayment VOUCHER_PAYMENT = KondutoPaymentFactory.getVoucherPayment();

    @Test
    public void typeIsDebitTest() {
        assertEquals(KondutoPaymentType.VOUCHER, VOUCHER_PAYMENT.getType());
    }
}
