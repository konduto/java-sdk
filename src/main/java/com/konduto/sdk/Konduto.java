package com.konduto.sdk;

import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoHTTPExceptionFactory;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.exceptions.KondutoInvalidOrderStatusException;
import com.konduto.sdk.models.KondutoOrder;
import com.konduto.sdk.models.KondutoOrderStatus;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

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
	private static JSONObject responseBody;
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
		if(Konduto.responseBody != null) {
			sb.append(String.format("Response body: %s\n", Konduto.responseBody.toString()));
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

	private static String kondutoPutOrderUrl(String orderId) {
		return String.format("%s/orders/%s", kondutoUrl(), orderId);
	}

	private static JSONObject extractResponse(HttpMethod method) throws IOException {
		byte[] responseBodyAsByteArray = method.getResponseBody();
		String responseBodyAsString = new String(responseBodyAsByteArray, "UTF-8");
		return new JSONObject(responseBodyAsString);
	}

	public static KondutoOrder getOrder(String orderId) throws KondutoHTTPException {
		GetMethod getMethod = new GetMethod(kondutoGetOrderUrl(orderId));

		JSONObject responseBody = sendRequest(getMethod, null);

		KondutoOrder order = KondutoOrder.fromJSON(responseBody);

		return order;
	}

	private static StringRequestEntity getRequestEntity(JSONObject requestBody) throws UnsupportedEncodingException {
		StringRequestEntity requestEntity = new StringRequestEntity(
				requestBody.toString(),
				"application/json",
				"UTF-8"
		);

		return requestEntity;
	}

	private static JSONObject sendRequest(HttpMethod method, JSONObject requestBody) throws KondutoHTTPException {
		JSONObject responseBody = new JSONObject();

		HttpClient httpClient = new HttpClient();

		try {
			if(method instanceof PostMethod){
				Konduto.requestBody = requestBody; // set Konduto's request body for debugging purposes
				((PostMethod) method).setRequestEntity(getRequestEntity(requestBody));
			} else if (method instanceof PutMethod) {
				Konduto.requestBody = requestBody; // set Konduto's request body for debugging purposes
				((PutMethod) method).setRequestEntity(getRequestEntity(requestBody));
			}

			int statusCode = httpClient.executeMethod(method);

			responseBody = extractResponse(method);

			Konduto.responseBody = responseBody; // set Konduto's response body for debugging purposes

			if(statusCode != 200) { throw KondutoHTTPExceptionFactory.buildException(statusCode, responseBody); }

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}

		return responseBody;
	}

	public static void analyze(KondutoOrder order)
			throws KondutoInvalidEntityException, KondutoHTTPException {

		PostMethod postMethod = new PostMethod(kondutoPostOrderUrl());

		JSONObject responseBody = sendRequest(postMethod, order.toJSON());

		KondutoOrder.fromJSON(order, responseBody);

	}

	public static boolean updateOrderStatus(String orderId, KondutoOrderStatus status, String comments)
			throws KondutoHTTPException, KondutoInvalidOrderStatusException {

		List<KondutoOrderStatus> allowedStatuses = Arrays.asList(
				KondutoOrderStatus.APPROVED,
				KondutoOrderStatus.DECLINED,
				KondutoOrderStatus.FRAUD
		);

		if (!allowedStatuses.contains(status)){ throw new KondutoInvalidOrderStatusException(status); }
		if (comments == null){ throw new NullPointerException("comments cannot be null"); }

		PutMethod putMethod = new PutMethod(kondutoPutOrderUrl(orderId));

		JSONObject requestBody = new JSONObject();
		requestBody.put("status", status.getText());
		requestBody.put("comments", comments);

		JSONObject responseBody = sendRequest(putMethod, requestBody);

		return (responseBody.has("old_status") && responseBody.has("new_status"));
	}
}
