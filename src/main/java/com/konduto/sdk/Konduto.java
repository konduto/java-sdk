package com.konduto.sdk;

import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoHTTPExceptionFactory;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.exceptions.KondutoUnexpectedAPIResponseException;
import com.konduto.sdk.models.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
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
	private static String requestBody;
	private static String responseBody;
	private static URI endpoint = URI.create("https://api.konduto.com/v1");

	protected static void setEndpoint(URI endpoint) {
		Konduto.endpoint = endpoint;
	}

	private Konduto() { /* cannot be instantiated */  }

	public static void setApiKey(String apiKey) {
		if (apiKey == null || apiKey.length() != 21) {
			throw new IllegalArgumentException("Illegal API Key: " + apiKey);
		}
		Konduto.apiKey = apiKey;
	}

	public static String debug() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("API Key: %s\n", Konduto.apiKey));
		sb.append(String.format("Endpoint: %s\n", Konduto.endpoint.toString()));
		if(Konduto.requestBody != null) {
			sb.append(String.format("Request body: %s\n", Konduto.requestBody));
		}
		if(Konduto.responseBody != null) {
			sb.append(String.format("Response body: %s\n", Konduto.responseBody));
		}
		return sb.toString();
	}

	protected static URI kondutoGetOrderUrl(String orderId) {
		return URI.create(endpoint.toString().concat("/orders/" + orderId));
	}

	protected static URI kondutoPostOrderUrl(){
		return URI.create(endpoint.toString().concat("/orders"));
	}

	protected static URI kondutoPutOrderUrl(String orderId) {
		return URI.create(endpoint.toString().concat("/orders/" + orderId));
	}

	private static String extractResponse(HttpMethod method) throws IOException {
		byte[] responseBodyAsByteArray = method.getResponseBody();
		return new String(responseBodyAsByteArray, "UTF-8");
	}

	private static StringRequestEntity getRequestEntity(String requestBody) throws UnsupportedEncodingException {
		return new StringRequestEntity(
				requestBody,
				"application/json",
				"UTF-8"
		);
	}


	private static String sendRequest(HttpMethod method, String requestBody) throws KondutoHTTPException {

		if(apiKey == null) { throw new NullPointerException("API key cannot be null"); }

		String responseBody;

		HttpClient httpClient = new HttpClient();

		String base64 = null;
		try {
			base64 = new String(Base64.encodeBase64(apiKey.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			base64 = new String(Base64.encodeBase64(apiKey.getBytes()));
		} finally {
			method.addRequestHeader("Authorization", "Basic " + base64);
		}

		try {
			if(method instanceof PostMethod) {
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

			return responseBody;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}

		return null;
	}

	public static KondutoOrder getOrder(String orderId)
			throws KondutoHTTPException, KondutoUnexpectedAPIResponseException {
		GetMethod getMethod = new GetMethod(kondutoGetOrderUrl(orderId).toString());

		String responseBody;

		responseBody = sendRequest(getMethod, null);

		if(responseBody == null || !responseBody.contains("order")) {
			throw new KondutoUnexpectedAPIResponseException(responseBody);
		}

		JSONObject responseBodyAsJSON = new JSONObject(responseBody).getJSONObject("order");

		KondutoOrder order = (KondutoOrder) KondutoModel.fromJSON(responseBodyAsJSON.toString(), KondutoOrder.class);

		return order;
	}

	public static void analyze(KondutoOrder order)
			throws KondutoInvalidEntityException, KondutoHTTPException, KondutoUnexpectedAPIResponseException {

		PostMethod postMethod = new PostMethod(kondutoPostOrderUrl().toString());

		String responseBody;

		responseBody = sendRequest(postMethod, order.toJSON());

		if(responseBody == null || !responseBody.contains("order")) {
			throw new KondutoUnexpectedAPIResponseException(responseBody);
		}

		JSONObject responseBodyAsJSON = new JSONObject(responseBody).getJSONObject("order");

		if(responseBodyAsJSON.has("status")){
			order.setStatus(KondutoOrderStatus.valueOf(responseBodyAsJSON.getString("status").toUpperCase()));
		}

		if(responseBodyAsJSON.has("score")){
			order.setScore(responseBodyAsJSON.getDouble("score"));
		}

		if(responseBodyAsJSON.has("recommendation")){
			order.setRecommendation(KondutoRecommendation.valueOf(responseBodyAsJSON.getString("recommendation").toUpperCase()));
		}

		if(responseBodyAsJSON.has("geolocation")){
			order.setGeolocation((KondutoGeolocation) KondutoModel.fromJSON(responseBody, KondutoGeolocation.class));

		}

//		if(responseBodyAsJSON.has("device")){
//
//		}
//
//
//		if(responseBodyAsJSON.has("navigation")){
//
//		}

	}

	public static void updateOrderStatus(String orderId, KondutoOrderStatus status, String comments)
			throws KondutoHTTPException, KondutoUnexpectedAPIResponseException {

		List<KondutoOrderStatus> allowedStatuses = Arrays.asList(
				KondutoOrderStatus.APPROVED,
				KondutoOrderStatus.DECLINED,
				KondutoOrderStatus.FRAUD
		);

		if (!allowedStatuses.contains(status)){ throw new IllegalArgumentException("Illegal status: " + status); }
		if (comments == null){ throw new NullPointerException("comments cannot be null"); }

		PutMethod putMethod = new PutMethod(kondutoPutOrderUrl(orderId).toString());

		JSONObject requestBody = new JSONObject();
		requestBody.put("status", status.toString().toLowerCase());
		requestBody.put("comments", comments);

		String responseBody;

		responseBody = sendRequest(putMethod, requestBody.toString());

		if (responseBody == null || !responseBody.contains("old_status") || !responseBody.contains("new_status")) {
			throw new KondutoUnexpectedAPIResponseException(responseBody);
		}

	}
}