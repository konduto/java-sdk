package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.KondutoCreditCardPayment;
import com.konduto.sdk.models.KondutoPayment;
import com.konduto.sdk.models.KondutoPaymentType;

import java.lang.reflect.Type;

/**
 *
 * This adapter is used to tell GSON how to serialize from/deserialize to {@link KondutoPayment} children instances.
 *
 */
public class KondutoPaymentAdapter implements JsonSerializer<KondutoPayment>, JsonDeserializer<KondutoPayment> {

	/**
	 * Method to serialize a {@link KondutoPayment} into a JSON object.
	 *
	 * @param src a KondutoPayment instance
	 * @param typeOfSrc KondutoPayment class
	 * @param context GSON serialization context
	 * @return the object serialized
	 */
	@Override
	public JsonElement serialize(KondutoPayment src, Type typeOfSrc, JsonSerializationContext context) {
		switch (src.getType()){
			case CREDIT:
				return context.serialize(src, KondutoCreditCardPayment.class);
		}
		return null;
	}

	/**
	 * Method to deserialize a JSON object into a {@link KondutoPayment} instance.
	 *
	 * @param json a serialized object
	 * @param typeOfT the object type
	 * @param context GSON serialization context
	 * @return an instance of KondutoPayment (e.g a KondutoCreditCardPayment instance) or null
	 * @throws JsonParseException
	 */
	@Override
	public KondutoPayment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		KondutoPaymentType type =
				KondutoPaymentType.valueOf(((JsonObject) json).get("type").getAsString().toUpperCase());
		switch (type){
			case CREDIT:
				return context.deserialize(json, KondutoCreditCardPayment.class);
		}
		return null;
	}
}

