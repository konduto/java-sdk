package com.konduto.sdk.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.konduto.sdk.models.KondutoDebitPayment;

public class KondutoDebitPaymentSerializer extends KondutoPaymentSerializer {

    JsonElement completeSerialization(JsonObject paymentAsJson, KondutoDebitPayment debitPayment) {
        paymentAsJson.addProperty("sha1", debitPayment.getSha1());
        paymentAsJson.addProperty("status", debitPayment.getStatusAsString());
        paymentAsJson.addProperty("bin", debitPayment.getBin());
        paymentAsJson.addProperty("last4", debitPayment.getLast4());
        paymentAsJson.addProperty("expiration_date", debitPayment.getExpirationDate());
        paymentAsJson.addProperty("cvv_result", debitPayment.getCvvResult());
        paymentAsJson.addProperty("avs_result", debitPayment.getAvsResult());
        paymentAsJson.addProperty("tax_id", debitPayment.getTaxId());
        paymentAsJson.addProperty("number_of_retries", debitPayment.getNumberOfRetries());
        return paymentAsJson;
    }
}
