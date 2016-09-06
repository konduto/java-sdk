package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * This adapter is used to tell GSON how to serialize/deserialize collections of KondutoPayments.
 *
 */
public class KondutoPaymentAdapter implements JsonSerializer<KondutoPayment>,
		JsonDeserializer<Collection<KondutoPayment>> {

	/**
	 * Method to serialize a collection of KondutoPayments into a JSON object.
	 *
	 * @param payments a collection of KondutoPayment instances
	 * @param typeOfSrc KondutoPayment class
	 * @param context GSON serialization context
	 * @return the object serialized
	 */
	@Override
	public JsonElement serialize(KondutoPayment payment, Type typeOfSrc, JsonSerializationContext context) {
//		JsonArray paymentsJSON = new JsonArray();

//		for(KondutoPayment payment : payments) {
		JsonObject serializedPayment = null;
		switch (payment.getType()){
			case BOLETO:
				serializedPayment = (JsonObject) context.serialize(payment, KondutoBoletoPayment.class);
				break;
			case CREDIT:
				serializedPayment = (JsonObject) context.serialize(payment, KondutoCreditCardPayment.class);
				break;
			case DEBIT:
				serializedPayment = (JsonObject) context.serialize(payment, KondutoDebitPayment.class);
				break;
			case TRANSFER:
				serializedPayment = (JsonObject) context.serialize(payment, KondutoTransferPayment.class);
				break;
			case VOUCHER:
				serializedPayment = (JsonObject) context.serialize(payment, KondutoVoucherPayment.class);
				break;
		}
		serializedPayment.addProperty("type", payment.getType().toString().toLowerCase());

		return serializedPayment;
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

		Collection<KondutoPayment> payments = new ArrayList<KondutoPayment>();

		for(JsonElement je : json.getAsJsonArray()) {
			KondutoPaymentType type =
					KondutoPaymentType.valueOf(((JsonObject) je).get("type").getAsString().toUpperCase());
			switch (type){
				case BOLETO:
					payments.add((KondutoBoletoPayment) context.deserialize(je, KondutoBoletoPayment.class));
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

