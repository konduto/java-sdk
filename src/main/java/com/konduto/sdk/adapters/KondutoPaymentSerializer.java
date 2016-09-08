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
     * Gson invokes this call-back method during serialization when it encounters a field of the
     * specified type.
     * <p/>
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonSerializationContext#serialize(Object, Type)} method to create JsonElements for any
     * non-trivial field of the {@code src} object. However, you should never invoke it on the
     * {@code src} object itself since that will cause an infinite loop (Gson will call your
     * call-back method again).</p>
     *
     * @param src       the object that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully genericized version) of the source object.
     * @param context
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
