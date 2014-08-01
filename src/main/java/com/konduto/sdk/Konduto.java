package com.konduto.sdk;

/**
 * Created by rsampaio on 30/07/14.
 *
 * Konduto is the HTTP Client for connecting to our API.
 *
 */

public final class Konduto {
	private static String apiKey;
	private static String version;
	private static String requestBody;
	private static final String ENDPOINT = "https://api.konduto.com";

	public static void setApiKey(String apiKey) {
		Konduto.apiKey = apiKey;
	}

	public static void setVersion(String version) {
		Konduto.version = version;
	}

	public static void setRequestBody(String requestBody) {
		Konduto.requestBody = requestBody;
	}

	public static String debug() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("API Key: %s\n", Konduto.apiKey));
		sb.append(String.format("version: %s\n", Konduto.version));
		sb.append(String.format("requestBody: %s\n", Konduto.requestBody));
		return sb.toString();
	}

	private Konduto() { /* cannot be instantiated */  }

}
