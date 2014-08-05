package com.konduto.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.konduto.sdk.exceptions.*;
import com.konduto.sdk.factories.KondutoOrderFactory;
import com.konduto.sdk.models.KondutoOrder;
import com.konduto.sdk.models.KondutoOrderStatus;
import com.konduto.sdk.models.KondutoRecommendation;
import org.apache.commons.httpclient.HttpStatus;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

/**
 * Created by rsampaio on 30/07/14.
 */
public class KondutoTest {
	private static final String ORDER_ID = "1406910391037";

	private static final String AUTH_HEADER = "Basic VDczOEQ1MTZGMDlDQUIzQTJDMUVF";
	private static final String API_KEY = "T738D516F09CAB3A2C1EE";

	private static final int[] HTTP_STATUSES = {
			HttpStatus.SC_UNAUTHORIZED, // 401
			HttpStatus.SC_FORBIDDEN, // 403
			HttpStatus.SC_NOT_FOUND, // 404
			HttpStatus.SC_UNPROCESSABLE_ENTITY, // 422
			HttpStatus.SC_METHOD_NOT_ALLOWED, // 425
			429, // 429
			HttpStatus.SC_INTERNAL_SERVER_ERROR // 500
	};

	@Rule
	public WireMockRule wireMockRule = new WireMockRule();

	@Before
	public void setupKonduto(){
		Konduto.setEndpoint(URI.create("http://localhost:8080/v1"));
		try {
			Konduto.setApiKey(API_KEY);
		} catch (KondutoInvalidApiKeyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getOrderSuccessfullyTest(){

		stubFor(get(urlEqualTo("/v1/orders/" + ORDER_ID))
				.withHeader("Authorization", equalTo(AUTH_HEADER))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder expectedOrder = KondutoOrder.fromJSON(
				readJSONFromFile("__files/order.json"));

		KondutoOrder actualOrder = null;

		try {
			 actualOrder = Konduto.getOrder(ORDER_ID);
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
			fail("[GET] should succeed");
		}

		assertEquals(expectedOrder, actualOrder);
	}

	@Test
	public void getOrderErrorTest(){
		for(int httpStatus: HTTP_STATUSES) {
			stubFor(get(urlEqualTo("/v1/orders/" + ORDER_ID))
					.withHeader("Authorization", equalTo(AUTH_HEADER))
					.willReturn(aResponse()
							.withStatus(httpStatus)
							.withHeader("Content-Type", "application/json")
							.withBody("{}")));
			try {
				Konduto.getOrder(ORDER_ID);
				fail("Exception expected");
			} catch (KondutoHTTPException e) {
				// nothing to do, because exception was expected
			} catch (KondutoUnexpectedAPIResponseException e) {
				fail("KondutoHTTPException was expected");
			}
		}

	}

	@Test
	public void analyzeSuccessfullyTest() {
		stubFor(post(urlEqualTo("/v1/orders"))
				.withHeader("Authorization", equalTo(AUTH_HEADER))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder orderToSend = KondutoOrderFactory.basicOrder();

		assertNull("basic order should have no recommendation", orderToSend.getRecommendation());

		try {
			Konduto.analyze(orderToSend); // do analyze
		} catch (KondutoInvalidEntityException e) {
			fail("order should be valid");
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
			fail("server should respond with status 200");
		}

		KondutoRecommendation actualRecommendation =
				KondutoOrder.fromJSON(readJSONFromFile("__files/order.json")).getRecommendation();

		assertEquals(orderToSend.getRecommendation(), actualRecommendation);

	}

	@Test
	public void analyzeInvalidOrderTest(){
		stubFor(post(urlEqualTo("/v1/orders"))
				.withHeader("Authorization", equalTo(AUTH_HEADER))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder order = new KondutoOrder();

		try {
			Konduto.analyze(order);
			fail("KondutoInvalidEntityException should have been thrown");
		} catch (KondutoInvalidEntityException e) {
			// nothing to do, because exception was expected
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
			fail("Expected KondutoInvalidEntityException, but got KondutoHTTPException");
		}
	}


	@Test
	public void analyzeHTTPErrorTest(){
		for(int httpStatus: HTTP_STATUSES) {
			stubFor(post(urlEqualTo("/v1/orders"))
					.withHeader("Authorization", equalTo(AUTH_HEADER))
					.willReturn(aResponse()
							.withStatus(httpStatus)
							.withHeader("Content-Type", "application/json")
							.withBody("{}")));
			try {
				Konduto.analyze(KondutoOrderFactory.basicOrder());
				fail("Exception expected");
			} catch (KondutoHTTPException e) {
				// nothing to do, because exception was expected
			} catch (KondutoInvalidEntityException | KondutoUnexpectedAPIResponseException e) {
				fail("expected KondutoHTTPException");
			}
		}
	}

	@Test
	public void updateSuccessfullyTest(){
		stubFor(put(urlEqualTo("/v1/orders/" + ORDER_ID))
				.withHeader("Authorization", equalTo(AUTH_HEADER))
				.withRequestBody(equalTo("{\"status\":\"approved\",\"comments\":\"no comments\"}"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody("{\"old_status\":\"review\",\"new_status\":\"approved\"}")));

		try {
			Konduto.updateOrderStatus(ORDER_ID, KondutoOrderStatus.APPROVED, "no comments");
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException | KondutoInvalidOrderStatusException e) {
			fail("order update should have succeeded");
		}

	}

	@Test
	public void updateHTTPErrorTest(){
		for(int httpStatus : HTTP_STATUSES){
			stubFor(put(urlEqualTo("/v1/orders/" + ORDER_ID))
					.withHeader("Authorization", equalTo(AUTH_HEADER))
					.willReturn(aResponse()
							.withStatus(httpStatus)
							.withHeader("Content-Type", "application/json")
							.withBody("{}")));
		}

		try {
			Konduto.updateOrderStatus(ORDER_ID, KondutoOrderStatus.APPROVED, "no comments");
			fail("exception expected");
		} catch (KondutoHTTPException e) {
			// nothing to do, because exception was expected
		} catch (KondutoInvalidOrderStatusException | KondutoUnexpectedAPIResponseException e) {
			fail("KondutoHTTPException was expected");
		}
	}

	@Test
	public void invalidStatusWhenUpdatingTest(){
		List<KondutoOrderStatus> forbiddenStatus = Arrays.asList(
			KondutoOrderStatus.NOT_ANALYZED,
			KondutoOrderStatus.PENDING
		);

		for (KondutoOrderStatus status : forbiddenStatus) {
			try {
				Konduto.updateOrderStatus(ORDER_ID, status, "");
				fail("expected KondutoInvalidOrderStatus exception");
			} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
				fail("expected KondutoInvalidOrderStatus exception");
			} catch (KondutoInvalidOrderStatusException kondutoInvalidOrderStatusException) {
				// nothing to do, because exception was expected
			}
		}
	}

	@Test(expected=NullPointerException.class)
	public void nullCommentsWhenUpdatingTest(){
		try {
			Konduto.updateOrderStatus(ORDER_ID, KondutoOrderStatus.APPROVED, null);
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException | KondutoInvalidOrderStatusException e) {
			fail("expected NullPointerException");
		}
	}

	@Test(expected = KondutoInvalidApiKeyException.class)
	public void invalidApiKeyTest() throws KondutoInvalidApiKeyException {
		Konduto.setApiKey("invalid key");
	}


	private JSONObject readJSONFromFile(String resourceName) {
		try {
			URL resource = Thread.currentThread().getContextClassLoader().getResource(resourceName);
			if(resource != null) {
				URI uri = resource.toURI();
				byte[] bytes = Files.readAllBytes(Paths.get(uri));
				return new JSONObject(new String(bytes, "UTF-8"));
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
