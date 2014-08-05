package com.konduto.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.exceptions.KondutoInvalidOrderStatusException;
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

import static org.junit.Assert.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by rsampaio on 30/07/14.
 */
public class KondutoTest {
	private static final String ORDER_ID = "1406910391037";

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
		Konduto.setEndpoint("http://localhost:8080");
		Konduto.setVersion("v1");
	}

	@Test
	public void getOrderSuccessfullyTest(){

		stubFor(get(urlEqualTo("/v1/orders/" + ORDER_ID))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder expectedOrder = KondutoOrder.fromJSON(
				readJSONFromFile("__files/order.json"));

		KondutoOrder actualOrder = null;

		try {
			 actualOrder = Konduto.getOrder(ORDER_ID);
		} catch (KondutoHTTPException e) {
			e.printStackTrace();
		}

		assertEquals(expectedOrder, actualOrder);
	}

	@Test
	public void getOrderErrorTest(){
		for(int httpStatus: HTTP_STATUSES) {
			stubFor(get(urlEqualTo("/v1/orders/" + ORDER_ID))
					.willReturn(aResponse()
							.withStatus(httpStatus)
							.withHeader("Content-Type", "application/json")
							.withBody("{}")));
			try {
				Konduto.getOrder(ORDER_ID);
				fail("Exception expected");
			} catch (KondutoHTTPException e) {
				// nothing to do, because exception was expected
			}
		}

	}

	@Test
	public void analyzeSuccessfullyTest() {
		stubFor(post(urlEqualTo("/v1/orders")).
				willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder orderToSend = KondutoOrderFactory.basicOrder();

		assertNull("basic order should have no recommendation", orderToSend.getRecommendation());

		try {
			Konduto.analyze(orderToSend); // do analyze
		} catch (KondutoInvalidEntityException e) {
			fail("order should be valid");
		} catch (KondutoHTTPException e) {
			fail("server should respond with status 200");
		}

		KondutoRecommendation actualRecommendation =
				KondutoOrder.fromJSON(readJSONFromFile("__files/order.json")).getRecommendation();

		assertEquals(orderToSend.getRecommendation(), actualRecommendation);

	}

	@Test
	public void analyzeInvalidOrderTest(){
		stubFor(post(urlEqualTo("/v1/orders")).
				willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder order = new KondutoOrder();

		try {
			Konduto.analyze(order);
			fail("KondutoInvalidEntityException should have been thrown");
		} catch (KondutoInvalidEntityException e) {
			// nothing to do, because exception was expected
		} catch (KondutoHTTPException e) {
			fail("Expected KondutoInvalidEntityException, but got KondutoHTTPException");
		}
	}


	@Test
	public void analyzeHTTPErrorTest(){
		for(int httpStatus: HTTP_STATUSES) {
			stubFor(post(urlEqualTo("/v1/orders"))
					.willReturn(aResponse()
							.withStatus(httpStatus)
							.withHeader("Content-Type", "application/json")
							.withBody("{}")));
			try {
				Konduto.analyze(KondutoOrderFactory.basicOrder());
				fail("Exception expected");
			} catch (KondutoHTTPException e) {
				// nothing to do, because exception was expected
			} catch (KondutoInvalidEntityException e) {
				fail("order should be valid");
			}
		}
	}

	@Test
	public void updateSuccessfullyTest(){
		stubFor(put(urlEqualTo("/v1/orders/" + ORDER_ID))
				.withRequestBody(equalTo("{\"status\":\"approved\",\"comments\":\"no comments\"}"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody("{\"old_status\":\"review\",\"new_status\":\"approved\"}")));

		boolean updateSucceeded = false;

		try {
			updateSucceeded = Konduto.updateOrderStatus(ORDER_ID, KondutoOrderStatus.APPROVED, "no comments");
		} catch (KondutoHTTPException e) {
			fail("status update should succeed");
		} catch (KondutoInvalidOrderStatusException kondutoInvalidOrderStatusException) {
			fail("status update should succeed");
		}

		assertTrue("update should succeeded", updateSucceeded);

	}

	@Test
	public void updateHTTPErrorTest(){
		for(int httpStatus : HTTP_STATUSES){
			stubFor(put(urlEqualTo("/v1/orders/" + ORDER_ID))
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
		} catch (KondutoInvalidOrderStatusException kondutoInvalidOrderStatusException) {
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
			} catch (KondutoHTTPException e) {
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
		} catch (KondutoHTTPException e) {
			fail("expected NullPointerException");
		} catch (KondutoInvalidOrderStatusException kondutoInvalidOrderStatusException) {
			fail("expected NullPointerException");
		}
	}


	private JSONObject readJSONFromFile(String resourceName) {
		try {
			URL resource = Thread.currentThread().getContextClassLoader().getResource(resourceName);
			if(resource != null) {
				URI uri = resource.toURI();
				byte[] bytes = Files.readAllBytes(Paths.get(uri));
				return new JSONObject(new String(bytes, "UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
