package com.konduto.sdk.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.adapters.KondutoBankDestinationAccountAdapter;
import com.konduto.sdk.adapters.KondutoBankOriginAccountAdapter;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoBankDestinationAccountFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 10/06/2022.
 */
public class KondutoBankDestinationAccountTest {
	KondutoBankDestinationAccount sender = KondutoBankDestinationAccountFactory.getSenderAccount();

	JsonObject senderJSON =
			(JsonObject) TestUtils.readJSONFromFile("destination_accounts.json").getAsJsonArray().get(0);

	@Test
	public void deserializationtest() {
		assertEquals("deserialization failed", sender, KondutoModel.fromJSON(senderJSON, KondutoBankDestinationAccount.class));
	}
}
