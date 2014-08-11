package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.KondutoCreditCardPayment;
import com.konduto.sdk.models.KondutoPayment;
import com.konduto.sdk.models.KondutoPaymentType;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * This adapter is used to tell GSON how to serialize/deserialize collections of KondutoPayments.
 *
 */
public class KondutoPaymentAdapter implements JsonSerializer<Collection<KondutoPayment>>, JsonDeserializer<Collection<KondutoPayment>> {

	/**
	 * Method to serialize a collection of KondutoPayments into a JSON object.
	 *
	 * @param payments a collection of KondutoPayment instances
	 * @param typeOfSrc KondutoPayment class
	 * @param context GSON serialization context
	 * @return the object serialized
	 */
	@Override
	public JsonElement serialize(Collection<KondutoPayment> payments, Type typeOfSrc, JsonSerializationContext context) {
		JsonArray paymentsJSON = new JsonArray();

		for(KondutoPayment payment : payments) {
			switch (payment.getType()){
				case CREDIT:
					paymentsJSON.add(context.serialize(payment, KondutoCreditCardPayment.class));
			}
		}

		return paymentsJSON;
	}

	/**
	 * Method to deserialize a JSON object into a collection of KondutoPayments.
	 *
	 * @param json a serialized object
	 * @param typeOfT the object type
	 * @param context GSON serialization context
	 * @return an instance of KondutoPayment (e.g a KondutoCreditCardPayment instance) or null
	 * @throws JsonParseException
	 */
	@Override
	public Collection<KondutoPayment> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		Collection<KondutoPayment> payments = new HashSet<>();

		for(JsonElement je : json.getAsJsonArray()) {
			KondutoPaymentType type =
					KondutoPaymentType.valueOf(((JsonObject) je).get("type").getAsString().toUpperCase());
			switch (type){
				case CREDIT:
					payments.add((KondutoCreditCardPayment) context.deserialize(je, KondutoCreditCardPayment.class));
			}
		}

		return payments;
	}
}

