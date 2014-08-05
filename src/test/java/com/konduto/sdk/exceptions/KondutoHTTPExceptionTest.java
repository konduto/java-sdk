package com.konduto.sdk.exceptions;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 01/08/14.
 */
public class KondutoHTTPExceptionTest {

	private class KondutoFakeHTTPException extends KondutoHTTPException {
		protected KondutoFakeHTTPException(String message, JSONObject responseBody) {
			super(message, responseBody);
		}
	}

	@Test
	public void constructorTest(){
		String message = "fake message";
		JSONObject json = new JSONObject();
		KondutoFakeHTTPException fakeException = new KondutoFakeHTTPException(message, json);
		assertEquals(fakeException.getMessage(), String.format("%s - Response body: %s", message, json));
	}
}
