package com.konduto.sdk.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoBoletoPaymentTest {
    private KondutoBoletoPayment boletoPayment = new KondutoBoletoPayment();

    @Test
    public void isValidWithoutExpirationDate() {
        assertTrue(boletoPayment.isValid());
    }

    @Test
    public void throwsExceptionGivenUnparseableExpirationDate() {
        try {
            boletoPayment.setExpirationDate("2016-32-32");
            System.out.println(boletoPayment.getExpirationDate().toString());
            fail("expected exception");
        } catch (RuntimeException e){}
    }

    @Test
    public void typeIsBoletoTest() {
        assertEquals(KondutoPaymentType.BOLETO, boletoPayment.getType());
    }

}
