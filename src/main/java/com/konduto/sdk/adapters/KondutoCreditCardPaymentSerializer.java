package com.konduto.sdk.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.konduto.sdk.models.KondutoCreditCardPayment;

/**
 * Created by rsampaio on 9/8/16.
 *
 * Serializes a credit card payment.
 */
public class KondutoCreditCardPaymentSerializer extends KondutoPaymentSerializer {
    JsonElement completeSerialization(JsonObject paymentAsJson, KondutoCreditCardPayment creditCardPayment) {
        paymentAsJson.addProperty("sha1", creditCardPayment.getSha1());
        paymentAsJson.addProperty("status", creditCardPayment.getStatusAsString());
        paymentAsJson.addProperty("bin", creditCardPayment.getBin());
        paymentAsJson.addProperty("last4", creditCardPayment.getLast4());
        paymentAsJson.addProperty("expiration_date", creditCardPayment.getExpirationDate());
        paymentAsJson.addProperty("cvv_result", creditCardPayment.getCvvResult());
        paymentAsJson.addProperty("avs_result", creditCardPayment.getAvsResult());
        paymentAsJson.addProperty("tax_id", creditCardPayment.getTaxId());
        paymentAsJson.addProperty("number_of_retries", creditCardPayment.getNumberOfRetries());
        return paymentAsJson;
    }
}
