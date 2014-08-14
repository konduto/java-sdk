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
 */
public class KondutoPaymentAdapterTest {

	Type paymentsType = new TypeToken<Collection<KondutoPayment>>(){}.getType();

	Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(paymentsType, new KondutoPaymentAdapter())
			.create();

	Collection<KondutoPayment> payments = KondutoPaymentFactory.getPayments();

	JsonArray paymentsJSON = (JsonArray) TestUtils.readJSONFromFile("payments.json");

	@Test
	public void serializeTest(){
		assertEquals("serialization failed", paymentsJSON, gson.toJsonTree(payments));
	}

	@Test
	public void deserializeTest(){
		assertEquals("deserialization failed", payments, gson.fromJson(paymentsJSON, paymentsType));
	}
}
