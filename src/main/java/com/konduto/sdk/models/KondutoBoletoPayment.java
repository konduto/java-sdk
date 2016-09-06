package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

import java.util.Date;

/**
 * Created by rsampaio on 9/6/16.
 *
 */
public class KondutoBoletoPayment extends KondutoPayment {

    @Required
    private Date expirationDate;

    @Override
    public KondutoPaymentType getType() {
        return KondutoPaymentType.BOLETO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoBoletoPayment that = (KondutoBoletoPayment) o;

        if(this.getType() != that.getType()) { return false; }

        return expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + expirationDate.hashCode();
        return result;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
