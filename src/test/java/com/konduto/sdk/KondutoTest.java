package com.konduto.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoOrderFactory;
import com.konduto.sdk.models.KondutoOrder;
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

	@Test
	public void debugTest() {
		Konduto.setApiKey("API_KEY");
		Konduto.setVersion("1");
		String expectedDebug = "API key: API_KEY\n" +
				"version: 1\n";
		String actualDebug = Konduto.debug();
		assertTrue(expectedDebug.equalsIgnoreCase(actualDebug));
	}

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
	public void sendOrderSuccessfullyTest() {
		stubFor(post(urlEqualTo("/v1/orders")).
				willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder orderToSend = KondutoOrderFactory.basicOrder();

		assertNull("basic order should have no recommendation", orderToSend.getRecommendation());

		try {
			Konduto.sendOrder(orderToSend, true); // do analyze
		} catch (KondutoInvalidEntityException e) {
			fail("order should be valid");
		} catch (KondutoHTTPException e) {
			fail("server should respond with status 200");
		}

		assertTrue("analyze should be true", Konduto.getRequestBody().getBoolean("analyze"));

		KondutoRecommendation actualRecommendation =
				KondutoOrder.fromJSON(readJSONFromFile("__files/order.json")).getRecommendation();

		assertEquals(orderToSend.getRecommendation(), actualRecommendation);

		try {
			Konduto.sendOrder(orderToSend, false); // do analyze
		} catch (KondutoInvalidEntityException e) {
			e.printStackTrace();
		} catch (KondutoHTTPException e) {
			e.printStackTrace();
		}

		assertFalse("analyze should be false", Konduto.getRequestBody().getBoolean("analyze"));
	}

	@Test
	public void sendInvalidOrderTest(){
		stubFor(post(urlEqualTo("/v1/orders")).
				willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBodyFile("order.json")));

		KondutoOrder order = new KondutoOrder();

		try {
			Konduto.sendOrder(order, true);
			fail("KondutoInvalidEntityException should have been thrown");
		} catch (KondutoInvalidEntityException e) {
			// nothing to do, because exception was expected
		} catch (KondutoHTTPException e) {
			fail("Expected KondutoInvalidEntityException, but got KondutoHTTPException");
		}
	}


	@Test
	public void sendOrderHTTPErrorTest(){
		for(int httpStatus: HTTP_STATUSES) {
			stubFor(post(urlEqualTo("/v1/orders"))
					.willReturn(aResponse()
							.withStatus(httpStatus)
							.withHeader("Content-Type", "application/json")
							.withBody("{}")));
			try {
				Konduto.sendOrder(KondutoOrderFactory.basicOrder(), true);
				fail("Exception expected");
			} catch (KondutoHTTPException e) {
				// nothing to do, because exception was expected
			} catch (KondutoInvalidEntityException e) {
				fail("order should be valid");
			}
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
