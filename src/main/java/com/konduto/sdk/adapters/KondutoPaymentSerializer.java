package com.konduto.sdk.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konduto.sdk.models.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
        if(payment.getDescription() != null) {
            paymentAsJson.addProperty("description", payment.getDescription());
        }
        if(payment.getAmount() != null) {
            paymentAsJson.addProperty("amount",
                    BigDecimal.valueOf(payment.getAmount()).setScale(2,
                            RoundingMode.HALF_UP));
        }
        if(payment.getType().equals(KondutoPaymentType.CREDIT)) {
            KondutoCreditCardPaymentSerializer creditCardPaymentSerializer = new KondutoCreditCardPaymentSerializer();
            return creditCardPaymentSerializer.completeSerialization(paymentAsJson, (KondutoCreditCardPayment) payment);
        }
        if(payment.getType().equals(KondutoPaymentType.BOLETO)) {
            KondutoBoletoPaymentSerializer boletoPaymentSerializer = new KondutoBoletoPaymentSerializer();
            return boletoPaymentSerializer.completeSerialization(paymentAsJson, (KondutoBoletoPayment) payment);
        }
        if(payment.getType().equals(KondutoPaymentType.DEBIT)) {
            KondutoDebitPaymentSerializer debitPaymentSerializer = new KondutoDebitPaymentSerializer();
            return debitPaymentSerializer.completeSerialization(paymentAsJson, (KondutoDebitPayment) payment);
        }
        return paymentAsJson;
    }
}
