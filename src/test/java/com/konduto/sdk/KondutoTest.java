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

	private static final String AUTH_HEADER = "Basic VDczOEQ1MTZGMDlDQUIzQTJDMUVF";
	private static final String API_KEY = "T738D516F09CAB3A2C1EE";

	private static final JsonObject JSON_FROM_FILE =
			((JsonObject) TestUtils.readJSONFromFile("__files/order.json")).getAsJsonObject("order");

	private static final KondutoOrder ORDER_FROM_FILE =
			(KondutoOrder) KondutoModel.fromJSON(JSON_FROM_FILE, KondutoOrder.class);

	private static final String ORDER_ID = ORDER_FROM_FILE.getId();

	private static final int[] HTTP_STATUSES = {
			HttpStatus.SC_UNAUTHORIZED, // 401
			HttpStatus.SC_FORBIDDEN, // 403
			HttpStatus.SC_NOT_FOUND, // 404
			HttpStatus.SC_UNPROCESSABLE_ENTITY, // 422
			HttpStatus.SC_METHOD_NOT_ALLOWED, // 425
			429, // 429
			HttpStatus.SC_INTERNAL_SERVER_ERROR // 500
	};

	private Konduto konduto = new Konduto(API_KEY);

	@Rule
	public WireMockRule wireMockRule = new WireMockRule();

	@Before
	public void setupKonduto(){
		konduto.setEndpoint(URI.create("http://localhost:8080/v1"));
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
			 actualOrder = konduto.getOrder(ORDER_ID);

		} catch (KondutoHTTPException e) {
			fail("[GET] should succeed");
		} catch (KondutoUnexpectedAPIResponseException e) {
			fail("[GET] should succeed");
		}

        verify(getRequestedFor(urlMatching("/v1/orders/" + ORDER_ID)).withHeader("X-Requested-With",
                matching("Konduto Java SDK " + Konduto.VERSION)));
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
				konduto.getOrder(ORDER_ID);
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
		assertNull("basic order should have no external device", orderToSend.getExternalDevice());
		assertNull("basic order should have no navigation info", orderToSend.getNavigationInfo());
        assertTrue("basic order should have analyze set to true", orderToSend.getAnalyze());

		try {
			konduto.analyze(orderToSend); // do analyze
		} catch (KondutoInvalidEntityException e) {
			fail("order should be valid");
		} catch (KondutoHTTPException e) {
			fail("server should respond with status 200");
		} catch (KondutoUnexpectedAPIResponseException e) {
			fail("server should respond with status 200");
		}


		Double actualScore = ORDER_FROM_FILE.getScore();
		KondutoRecommendation actualRecommendation = ORDER_FROM_FILE.getRecommendation();
		KondutoGeolocation actualGeolocation = ORDER_FROM_FILE.getGeolocation();
		KondutoOrderStatus actualStatus = ORDER_FROM_FILE.getStatus();
		KondutoDevice actualDevice = ORDER_FROM_FILE.getDevice();
		KondutoNavigationInfo actualNavigationInfo = ORDER_FROM_FILE.getNavigationInfo();

        verify(postRequestedFor(urlMatching("/v1/orders")).withHeader("X-Requested-With",
                matching("Konduto Java SDK " + Konduto.VERSION)));

		assertEquals(orderToSend.getScore(), actualScore);
        assertEquals(orderToSend.getGeolocation(), actualGeolocation);
		assertEquals(orderToSend.getRecommendation(), actualRecommendation);
		assertEquals(orderToSend.getStatus(), actualStatus);
		assertEquals(orderToSend.getDevice(), actualDevice);
		assertEquals(orderToSend.getNavigationInfo(), actualNavigationInfo);

	}

    @Test
    public void sendOrderToKondutoButDoNotAnalyzeTest() {
        stubFor(post(urlEqualTo("/v1/orders"))
                .withHeader("Authorization", equalTo(AUTH_HEADER))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("order_not_analyzed.json")));

        KondutoOrder orderToSend = KondutoOrderFactory.basicOrder().with("analyze", false);
        assertFalse("order analyze should be false", orderToSend.getAnalyze());

        try {
            konduto.analyze(orderToSend); // do analyze
        } catch (KondutoInvalidEntityException e) {
            fail("order should be valid");
        } catch (KondutoUnexpectedAPIResponseException e) {
            fail("server should respond with status 200");
        } catch (KondutoHTTPException e) {
            fail("server should respond with status 200");
        }

        assertEquals(orderToSend.getScore(), new Double(-1));
        assertEquals(orderToSend.getRecommendation(), KondutoRecommendation.NONE);

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
			konduto.analyze(order);
			fail("KondutoInvalidEntityException should have been thrown");
		} catch (KondutoInvalidEntityException e) {
			// nothing to do, because exception was expected
		} catch (KondutoUnexpectedAPIResponseException e) {
			fail("Expected KondutoInvalidEntityException, but got KondutoHTTPException");
		} catch (KondutoHTTPException e) {
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
				konduto.analyze(KondutoOrderFactory.basicOrder());
				fail("Exception expected");
			} catch (KondutoHTTPException e) {
				// nothing to do, because exception was expected
			} catch (KondutoInvalidEntityException e) {
				fail("expected KondutoHTTPException");
			} catch (KondutoUnexpectedAPIResponseException e) {
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
						.withBody(
							"{ \"status\":\"ok\", \"order\": {\"old_status\":\"review\",\"new_status\":\"approved\"}}"
						)));

		try {
			konduto.updateOrderStatus(ORDER_FROM_FILE, KondutoOrderStatus.APPROVED, "no comments");
		} catch (KondutoHTTPException e) {
			fail("order update should have succeeded");
		} catch (KondutoUnexpectedAPIResponseException e) {
			fail("order update should have succeeded");
		}

        verify(putRequestedFor(urlMatching("/v1/orders/" + ORDER_ID)).withHeader("X-Requested-With",
                matching("Konduto Java SDK " + Konduto.VERSION)));

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
			konduto.updateOrderStatus(ORDER_FROM_FILE, KondutoOrderStatus.APPROVED, "no comments");
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
				konduto.updateOrderStatus(ORDER_FROM_FILE, status, "");
				fail("expected KondutoInvalidOrderStatus exception");
			} catch (KondutoHTTPException e) {
				fail("expected KondutoInvalidOrderStatus exception");
			} catch (KondutoUnexpectedAPIResponseException e) {
				fail("expected KondutoInvalidOrderStatus exception");
			}
		}
	}

	@Test(expected=NullPointerException.class)
	public void nullCommentsWhenUpdatingTest(){
		try {
			konduto.updateOrderStatus(ORDER_FROM_FILE, KondutoOrderStatus.APPROVED, null);
		} 
		catch (KondutoUnexpectedAPIResponseException e) {
			fail("expected NullPointerException");
		} 
		catch (KondutoHTTPException e) {
			fail("expected NullPointerException");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidApiKeyTest() {
		konduto.setApiKey("invalid key");
	}

}
