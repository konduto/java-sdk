package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * Deserialization of KondutoPayment collections.
 *
 */
public class KondutoPaymentCollectionDeserializer implements JsonDeserializer<Collection<KondutoPayment>> {

	/**
	 * Method to deserialize a JSON object into a collection of KondutoPayment.
	 *
	 * @param json a serialized object
	 * @param typeOfT the object type
	 * @param context GSON serialization context
	 * @return an ArrayList of payments
	 * @throws JsonParseException
	 */
	@Override
	public Collection<KondutoPayment> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		Collection<KondutoPayment> payments = new ArrayList<KondutoPayment>();

		for(JsonElement je : json.getAsJsonArray()) {
			JsonObject jo = (JsonObject) je;
			String pmtTypeUpper = jo.get("type").getAsString().toUpperCase();
			KondutoPaymentType type = KondutoPaymentType.valueOf(pmtTypeUpper);
			KondutoPayment pmt = type.deserialize(jo, context);
			if(jo.has("description")) {
				pmt.setDescription(jo.get("description").getAsString());
			}
			if(jo.has("amount")) {
				pmt.setAmount(jo.get("amount").getAsDouble());
			}
			payments.add(pmt);
		}

		return payments;
	}
}

