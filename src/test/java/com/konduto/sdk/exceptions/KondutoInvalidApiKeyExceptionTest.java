package com.konduto.sdk.exceptions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 05/08/14.
 */
public class KondutoInvalidApiKeyExceptionTest {
	@Test
	public void getMessageTest() {
		KondutoInvalidApiKeyException exception = new KondutoInvalidApiKeyException("123");
		assertEquals(String.format("%s is an invalid API Key", "123"), exception.getMessage());
	}
}
