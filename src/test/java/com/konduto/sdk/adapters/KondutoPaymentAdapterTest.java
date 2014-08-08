package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.factories.KondutoPaymentFactory;
import com.konduto.sdk.models.KondutoPayment;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 */
public class KondutoPaymentAdapterTest {
	Gson gson = new GsonBuilder()
			.registerTypeAdapter(KondutoPayment.class, new KondutoPaymentAdapter())
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();

	@Test
	public void serializePaymentTest(){
		KondutoPayment payment = KondutoPaymentFactory.getCreditCardPayment();
		assertEquals(TestUtils.readJSONFromFile("credit_card.json").toString(), gson.toJson(payment, KondutoPayment.class));
	}

	@Test
	public void deserializeTest(){
		KondutoPayment actualPayment = gson.fromJson(TestUtils.readJSONFromFile("credit_card.json"), KondutoPayment.class);
		KondutoPayment expectedPayment = KondutoPaymentFactory.getCreditCardPayment();

		assertEquals("deserialization failed", actualPayment, expectedPayment);

	}
}
