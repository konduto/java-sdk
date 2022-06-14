package com.konduto.sdk.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.adapters.KondutoBankOriginAccountAdapter;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoBankOriginAccountFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 09/06/2022.
 */
public class KondutoBankOriginAccountTest {

	Type bankOringinAccount = new TypeToken<KondutoBankOriginAccount>(){}.getType();

	Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(bankOringinAccount, new KondutoBankOriginAccountAdapter())
			.create();
	@Test
	public void serializeTest() throws ParseException {
		KondutoBankOriginAccount origin = KondutoBankOriginAccountFactory.getOriginAccount();
		JsonObject expectedJSON = (JsonObject) TestUtils.readJSONFromFile("origin_account.json");

		try {
			assertEquals(" Bank Origin Account serialization failed", expectedJSON, origin.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("Bank Origin Account should be valid" + e);
		}

		assertEquals("Bank Origin Account deserialization failed", origin, gson.fromJson(expectedJSON, bankOringinAccount));
	}
}
