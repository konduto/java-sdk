package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoOriginAccountFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 */
public class KondutoOriginAccountTest {

	@Test
	public void serializeTest() throws ParseException {
		KondutoOriginAccount origin = KondutoOriginAccountFactory.getOriginAccount();
		JsonObject expectedJSON = (JsonObject) TestUtils.readJSONFromFile("origin_account.json");

		try {
			assertEquals(" Bank Origin Account serialization failed", expectedJSON, origin.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("Bank Origin Account should be valid" + e);
		}

		KondutoOriginAccount originFromJSON = (KondutoOriginAccount) KondutoModel.fromJSON(expectedJSON, KondutoOriginAccount.class);

		assertEquals("Bank Origin Account deserialization failed", origin, originFromJSON);
	}

	@Test(expected=KondutoInvalidEntityException.class)
	public void invalidOriginAccountSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
		KondutoOriginAccount originAccount = new KondutoOriginAccount();
		originAccount.toJSON(); // triggers invalid customer exception
	}

}
