package com.konduto.sdk;

import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoHTTPExceptionFactory;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.models.KondutoOrder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
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
	private static JSONObject requestBody;
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

	public static String debug() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("API Key: %s\n", Konduto.apiKey));
		sb.append(String.format("version: %s\n", Konduto.version));
		if(Konduto.requestBody != null) {
			sb.append(String.format("Request body: %s\n", Konduto.requestBody.toString()));
		}
		return sb.toString();
	}

	private static String kondutoUrl() {
		return String.format("%s/%s", endpoint, version);
	}

	private static String kondutoGetOrderUrl(String orderId) {
		return String.format("%s/orders/%s", kondutoUrl(), orderId);
	}

	private static String kondutoPostOrderUrl(){
		return String.format("%s/orders", kondutoUrl());
	}

	private static JSONObject extractResponse(HttpMethod method) throws IOException {
		byte[] responseBodyAsByteArray = method.getResponseBody();
		String responseBodyAsString = new String(responseBodyAsByteArray, "UTF-8");
		return new JSONObject(responseBodyAsString);
	}

	public static KondutoOrder getOrder(String orderId) throws KondutoHTTPException {
		KondutoOrder order = null;
		HttpClient httpClient = new HttpClient();

		GetMethod getMethod = new GetMethod(kondutoGetOrderUrl(orderId));

		try {
			int statusCode = httpClient.executeMethod(getMethod);

			JSONObject responseBody = extractResponse(getMethod);

			if(statusCode != 200) { throw KondutoHTTPExceptionFactory.buildException(statusCode, responseBody); }

			order = KondutoOrder.fromJSON(responseBody);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}

		return order;
	}

	public static void analyze(KondutoOrder order)
			throws KondutoInvalidEntityException, KondutoHTTPException {
		HttpClient httpClient = new HttpClient();

		PostMethod postMethod = new PostMethod(kondutoPostOrderUrl());

		try {
			StringRequestEntity requestEntity = new StringRequestEntity(
					order.toJSON().toString(),
					"application/json",
					"UTF-8"
			);

			Konduto.requestBody = new JSONObject(requestEntity.getContent());

			postMethod.setRequestEntity(requestEntity);

			int statusCode = httpClient.executeMethod(postMethod);

			JSONObject responseBody = extractResponse(postMethod);

			if(statusCode != 200) { throw KondutoHTTPExceptionFactory.buildException(statusCode, responseBody); }

			KondutoOrder.fromJSON(order, responseBody);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
	}


}
