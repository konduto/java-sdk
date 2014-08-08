package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;

/**
 */
public class KondutoUnexpectedAPIResponseExceptionTest {
	@Test
	public void getMessageTest() {
		JsonObject responseBody = new JsonObject();
		KondutoUnexpectedAPIResponseException e = new KondutoUnexpectedAPIResponseException(responseBody);
		Assert.assertEquals("Unexpected API response: " + responseBody, e.getMessage());
	}
}
