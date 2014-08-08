package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 01/08/14.
 */
public class KondutoHTTPExceptionTest {

	private class KondutoFakeHTTPException extends KondutoHTTPException {
		protected KondutoFakeHTTPException(String message, JsonObject responseBody) {
			super(message, responseBody);
		}
	}

	@Test
	public void constructorTest(){
		String message = "fake message";
		JsonObject json = new JsonObject();
		KondutoFakeHTTPException fakeException = new KondutoFakeHTTPException(message, json);
		assertEquals(fakeException.getMessage(), String.format("%s - Response body: %s", message, json));
	}
}
