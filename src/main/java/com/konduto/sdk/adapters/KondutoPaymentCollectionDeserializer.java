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
			KondutoPaymentType type =
					KondutoPaymentType.valueOf(((JsonObject) je).get("type").getAsString().toUpperCase());
			switch (type){
				case BOLETO:
					KondutoBoletoPayment boletoPayment = new KondutoBoletoPayment();
					String expirationDateAsStr = ((JsonObject) je).get("expiration_date").getAsString();
					boletoPayment.setExpirationDate(expirationDateAsStr);
                    payments.add(boletoPayment);
					break;
				case CREDIT:
					payments.add((KondutoCreditCardPayment) context.deserialize(je, KondutoCreditCardPayment.class));
					break;
				case DEBIT:
					payments.add((KondutoDebitPayment) context.deserialize(je, KondutoDebitPayment.class));
					break;
				case TRANSFER:
					payments.add((KondutoTransferPayment) context.deserialize(je, KondutoTransferPayment.class));
					break;
				case VOUCHER:
					payments.add((KondutoVoucherPayment) context.deserialize(je, KondutoVoucherPayment.class));
					break;
			}
		}

		return payments;
	}
}

