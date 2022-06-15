package com.konduto.sdk.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.adapters.KondutoBankAdapter;
import com.konduto.sdk.adapters.KondutoBankDestinationAccountAdapter;
import com.konduto.sdk.factories.KondutoBankDestinationAccountFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 10/06/2022.
 */
public class KondutoBankDestinationAccountTest {

	Type bankDestinatioAccounts = new TypeToken<Collection<KondutoBankDestinationAccount>>(){}.getType();

	Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(bankDestinatioAccounts, new KondutoBankDestinationAccountAdapter())
			.create();
	List<KondutoBankDestinationAccount> accounts = KondutoBankDestinationAccountFactory.getDestinationAccounts();
	JsonArray accountsJSON =
			(JsonArray) TestUtils.readJSONFromFile("destination_accounts.json");

	@Test
	public void serializeTest() throws ParseException {
		try {
			assertEquals(" Bank Origin Account serialization failed", accountsJSON, gson.toJsonTree(accounts));
		} catch (RuntimeException e) {
			fail("Should be valid" + e);
		}
	}

	@Test
	public void deserializeTest() {
		assertEquals("deserialization failed", accounts, gson.fromJson(accountsJSON, bankDestinatioAccounts));
	}
}
