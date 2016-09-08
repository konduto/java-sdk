package com.konduto.sdk.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konduto.sdk.models.KondutoBoletoPayment;
import com.konduto.sdk.models.KondutoCreditCardPayment;
import com.konduto.sdk.models.KondutoPayment;
import com.konduto.sdk.models.KondutoPaymentType;

import java.lang.reflect.Type;

/**
 * Created by rsampaio on 9/8/16.
 *
 */
public class KondutoPaymentSerializer implements JsonSerializer<KondutoPayment> {
    /**
     * KondutoPayment serializer
     *
     * @param payment   the payment that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully genericized version) of the source object.
     * @param context   the serialization context
     * @return a JsonElement corresponding to the specified object.
     */
    @Override
    public JsonElement serialize(KondutoPayment payment, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject paymentAsJson = new JsonObject();
        paymentAsJson.addProperty("type", payment.getTypeAsString());
        if(payment.getType().equals(KondutoPaymentType.CREDIT)) {
            KondutoCreditCardPaymentSerializer creditCardPaymentSerializer = new KondutoCreditCardPaymentSerializer();
            return creditCardPaymentSerializer.completeSerialization(paymentAsJson, (KondutoCreditCardPayment) payment);
        }
        if(payment.getType().equals(KondutoPaymentType.BOLETO)) {
            KondutoBoletoPaymentSerializer boletoPaymentSerializer = new KondutoBoletoPaymentSerializer();
            return boletoPaymentSerializer.completeSerialization(paymentAsJson, (KondutoBoletoPayment) payment);
        }
        return paymentAsJson;
    }
}
