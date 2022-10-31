package com.konduto.sdk.models;

public class KondutoPixPayment extends KondutoPayment {

    @Override
    public KondutoPaymentType getType() {
        return KondutoPaymentType.PIX;
    }
}
