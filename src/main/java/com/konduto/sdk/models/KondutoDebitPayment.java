package com.konduto.sdk.models;

/**
 * Created by rsampaio on 9/6/16.
 */
public class KondutoDebitPayment extends KondutoPayment {
    @Override
    public KondutoPaymentType getType() {
        return KondutoPaymentType.DEBIT;
    }
}
