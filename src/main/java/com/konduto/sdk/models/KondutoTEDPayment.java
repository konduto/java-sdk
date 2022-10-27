package com.konduto.sdk.models;

public class KondutoTEDPayment extends KondutoPayment {

    @Override
    public KondutoPaymentType getType() {
        return KondutoPaymentType.TED;
    }
}
