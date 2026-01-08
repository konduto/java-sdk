package com.konduto.sdk.adapters;

import com.google.gson.JsonObject;
import com.konduto.sdk.models.KondutoBoletoPayment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
/**
 * Serializes a boleto payment.
 * Note the expiration date formatting.
 */
public class KondutoBoletoPaymentSerializer extends KondutoPaymentSerializer {

    /**
     * Default constructor.
     */
    public KondutoBoletoPaymentSerializer() {
    }

    /**
     * Completes the JSON serialization by adding boleto-specific fields including formatted expiration date.
     *
     * @param paymentAsJson the JSON object being built
     * @param boletoPayment the boleto payment to serialize
     * @return the updated JSON object
     */
    public JsonObject completeSerialization(JsonObject paymentAsJson, KondutoBoletoPayment boletoPayment) {
        Date expirationDate = boletoPayment.getExpirationDate();
        if(expirationDate == null) { return paymentAsJson; }
        SimpleDateFormat boletoDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        paymentAsJson.addProperty("expiration_date", boletoDateFormat.format(expirationDate));
        return paymentAsJson;
    }
}
