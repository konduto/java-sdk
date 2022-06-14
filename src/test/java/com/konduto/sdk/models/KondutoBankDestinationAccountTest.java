package com.konduto.sdk.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.adapters.KondutoBankDestinationAccountAdapter;
import com.konduto.sdk.factories.KondutoBankDestinationAccountFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 10/06/2022.
 */
public class KondutoBankDestinationAccountTest {

	Type bankDestinatioAccounts = new TypeToken<Collection<KondutoBankDestinationAccount>>(){}.getType();

	Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(bankDestinatioAccounts, new KondutoBankDestinationAccountAdapter())
			.create();
	Collection<KondutoBankDestinationAccount> accounts = KondutoBankDestinationAccountFactory.getDestinationAccounts();
	JsonArray accountsJSON =
			(JsonArray) TestUtils.readJSONFromFile("destination_accounts.json");

	@Test
	public void deserializeTest() {
		assertEquals("deserialization failed", accounts, gson.fromJson(accountsJSON, bankDestinatioAccounts));
	}
}
