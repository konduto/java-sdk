package com.konduto.sdk.adapters;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.factories.KondutoPaymentFactory;
import com.konduto.sdk.models.KondutoPayment;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Testes payment collection deserialization.
 */
public class KondutoPaymentCollectionDeserializerTest {

	Type paymentsCollectionType = new TypeToken<Collection<KondutoPayment>>(){}.getType();

	Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(paymentsCollectionType, new KondutoPaymentCollectionDeserializer())
			.create();

	Collection<KondutoPayment> payments = KondutoPaymentFactory.getPayments();

	JsonArray paymentsJSON = (JsonArray) TestUtils.readJSONFromFile("payments.json");

	@Test
	public void deserializeTest() {
		assertEquals("deserialization failed", payments,
				gson.fromJson(paymentsJSON, paymentsCollectionType));
	}
}
