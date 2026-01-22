package com.konduto.sdk.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rsampaio on 9/6/16.
 * Boleto payment model for Brazilian bank slip payments.
/**
 * Boleto payment model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoBoletoPayment extends KondutoPayment {

    private static final SimpleDateFormat BOLETO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    static {
        BOLETO_DATE_FORMAT.setLenient(false);
    }

    /**
     * Default constructor.
     */
    public KondutoBoletoPayment() {
    }

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

    /**
     * Gets the boleto expiration date.
     *
     * @return the boleto expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the boleto expiration date.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Sets the boleto expiration date from a string in yyyy-MM-dd format.
     *
     * @param expirationDateAsStr the expiration date as string
     * @throws RuntimeException if the date format is invalid
     */
    public void setExpirationDate(String expirationDateAsStr) {
        try {
            this.setExpirationDate(BOLETO_DATE_FORMAT.parse(expirationDateAsStr));
        } catch (ParseException e) {
            throw new RuntimeException("Invalid boleto date format: " + expirationDateAsStr);
        }
    }
}
