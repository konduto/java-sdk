package com.konduto.sdk;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rsampaio on 30/07/14.
 */
public class KondutoTest {

	@Test
	public void debugTest() {
		Konduto.setApiKey("API_KEY");
		Konduto.setVersion("1");
		Konduto.setRequestBody("{}");
		String expectedDebug = "API key: API_KEY\n" +
				"version: 1\n" +
				"requestBody: {}\n";
		String actualDebug = Konduto.debug();
		assertTrue(expectedDebug.equalsIgnoreCase(actualDebug));
	}

}
