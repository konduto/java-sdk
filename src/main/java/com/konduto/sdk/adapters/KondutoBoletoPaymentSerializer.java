package com.konduto.sdk.adapters;

import com.google.gson.JsonObject;
import com.konduto.sdk.models.KondutoBoletoPayment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rsampaio on 9/8/16.
 *
 * Serializes a boleto payment.
 * Note the expiration date formatting.
 */
public class KondutoBoletoPaymentSerializer extends KondutoPaymentSerializer {
    public JsonObject completeSerialization(JsonObject paymentAsJson, KondutoBoletoPayment boletoPayment) {
        Date expirationDate = boletoPayment.getExpirationDate();
        if(expirationDate == null) { return paymentAsJson; }
        SimpleDateFormat boletoDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        paymentAsJson.addProperty("expiration_date", boletoDateFormat.format(expirationDate));
        return paymentAsJson;
    }
}
