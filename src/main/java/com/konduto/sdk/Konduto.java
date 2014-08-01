package com.konduto.sdk;

import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoHTTPExceptionFactory;
import com.konduto.sdk.models.KondutoOrder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONObject;

import java.io.IOException;

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
	private static String endpoint;

	protected static void setEndpoint(String endpoint) {
		Konduto.endpoint = endpoint;
	}

	private Konduto() { /* cannot be instantiated */  }

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

	private static String kondutoUrl() {
		return String.format("%s/%s", endpoint, version);
	}

	private static String kondutoGetOrderUrl() {
		return String.format("%s/orders", kondutoUrl());
	}

	public static KondutoOrder getOrder(String orderId) {
		KondutoOrder order = null;
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(kondutoGetOrderUrl());
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			byte[] responseBodyAsByteArray = getMethod.getResponseBody();
			String responseBodyAsString = new String(responseBodyAsByteArray, "UTF-8");
			JSONObject responseBody = new JSONObject(responseBodyAsString);

			if(statusCode != 200) { throw KondutoHTTPExceptionFactory.buildException(statusCode, responseBody); }

			order = KondutoOrder.fromJSON(responseBody);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KondutoHTTPException e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}

		return order;
	}


}
