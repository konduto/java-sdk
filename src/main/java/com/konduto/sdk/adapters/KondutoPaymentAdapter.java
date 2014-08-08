package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.KondutoCreditCardPayment;
import com.konduto.sdk.models.KondutoPayment;
import com.konduto.sdk.models.KondutoPaymentType;

import java.lang.reflect.Type;

/**
 * Created by rsampaio on 08/08/14.
 */
public class KondutoPaymentAdapter implements JsonSerializer<KondutoPayment>, JsonDeserializer<KondutoPayment> {

	@Override
	public JsonElement serialize(KondutoPayment src, Type typeOfSrc, JsonSerializationContext context) {
		switch (src.getType()){
			case CREDIT:
				return context.serialize(src, KondutoCreditCardPayment.class);
		}
		return null;
	}

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
