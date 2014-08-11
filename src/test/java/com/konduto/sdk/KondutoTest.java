package com.konduto.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.exceptions.KondutoUnexpectedAPIResponseException;
import com.konduto.sdk.factories.KondutoOrderFactory;
import com.konduto.sdk.models.*;
import com.konduto.sdk.utils.TestUtils;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

/**
*/
public class KondutoTest {
	private static final String ORDER_ID = "1406910391037";

	private static final String AUTH_HEADER = "Basic VDczOEQ1MTZGMDlDQUIzQTJDMUVF";
	private static final String API_KEY = "T738D516F09CAB3A2C1EE";

	private static final JsonObject JSON_FROM_FILE =
			((JsonObject) TestUtils.readJSONFromFile("__files/order.json")).getAsJsonObject("order");

	private static final KondutoOrder ORDER_FROM_FILE =
			(KondutoOrder) KondutoModel.fromJSON(JSON_FROM_FILE, KondutoOrder.class);

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
		Konduto.setApiKey(API_KEY);
	}

	@Test
	public void getOrderSuccessfullyTest(){

		stubFor(get(urlEqualTo("/v1/orders/" + ORDER_ID))
				.withHeader("Authorization", equalTo(AUTH_HEADER))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder actualOrder = null;

		try {
			 actualOrder = Konduto.getOrder(ORDER_ID);

		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
			fail("[GET] should succeed");
		}

		assertEquals(ORDER_FROM_FILE, actualOrder);

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
		assertNull("basic order should have no score", orderToSend.getScore());
		assertNull("basic order should have no status", orderToSend.getStatus());
		assertNull("basic order should have no geolocation", orderToSend.getGeolocation());
		assertNull("basic order should have no device", orderToSend.getDevice());
		assertNull("basic order should have no navigation info", orderToSend.getNavigationInfo());

		try {
			Konduto.analyze(orderToSend); // do analyze
		} catch (KondutoInvalidEntityException e) {
			fail("order should be valid");
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
			fail("server should respond with status 200");
		}


		Double actualScore = ORDER_FROM_FILE.getScore();
		KondutoRecommendation actualRecommendation = ORDER_FROM_FILE.getRecommendation();
		KondutoGeolocation actualGeolocation = ORDER_FROM_FILE.getGeolocation();
		KondutoOrderStatus actualStatus = ORDER_FROM_FILE.getStatus();
		KondutoDevice actualDevice = ORDER_FROM_FILE.getDevice();
		KondutoNavigationInfo actualNavigationInfo = ORDER_FROM_FILE.getNavigationInfo();

		assertEquals(orderToSend.getScore(), actualScore);
		assertEquals(orderToSend.getGeolocation(), actualGeolocation);
		assertEquals(orderToSend.getRecommendation(), actualRecommendation);
		assertEquals(orderToSend.getStatus(), actualStatus);
		assertEquals(orderToSend.getDevice(), actualDevice);
		assertEquals(orderToSend.getNavigationInfo(), actualNavigationInfo);

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
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
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
		} catch (KondutoUnexpectedAPIResponseException e) {
			fail("KondutoHTTPException was expected");
		}
	}

	@Test(expected = IllegalArgumentException.class)
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
			}
		}
	}

	@Test(expected=NullPointerException.class)
	public void nullCommentsWhenUpdatingTest(){
		try {
			Konduto.updateOrderStatus(ORDER_ID, KondutoOrderStatus.APPROVED, null);
		} catch (KondutoHTTPException | KondutoUnexpectedAPIResponseException e) {
			fail("expected NullPointerException");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidApiKeyTest() {
		Konduto.setApiKey("invalid key");
	}

}
