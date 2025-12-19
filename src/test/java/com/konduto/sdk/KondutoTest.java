package com.konduto.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.exceptions.KondutoUnexpectedAPIResponseException;
import com.konduto.sdk.factories.KondutoOrderFactory;
import com.konduto.sdk.models.*;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.net.URI;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class KondutoTest {

    private static final String AUTH_HEADER = "Basic VDczOEQ1MTZGMDlDQUIzQTJDMUVF";
    private static final String API_KEY = "T738D516F09CAB3A2C1EE";

    private static final JsonObject JSON_FROM_FILE =
            ((JsonObject) TestUtils.readJSONFromFile("__files/order.json")).getAsJsonObject("order");

    private static final KondutoOrder ORDER_FROM_FILE =
            (KondutoOrder) KondutoModel.fromJSON(JSON_FROM_FILE, KondutoOrder.class);

    private static final String ORDER_ID = ORDER_FROM_FILE.getId();

    private static final int[] HTTP_STATUSES = { 401, 403, 404, 422, 405, 429, 500 };

    private Konduto konduto = new Konduto(API_KEY);

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);

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
        } catch (KondutoUnexpectedAPIResponseException e) {
            fail("[GET] should succeed, but it failed: " + e.getMessage());
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
                fail("Exception expected for status " + httpStatus);
            } catch (RuntimeException e) {
                assertTrue(e.getCause() instanceof KondutoHTTPException);
            } catch (KondutoUnexpectedAPIResponseException e) {
                fail("Expected RuntimeException, but got " + e.getClass().getName());
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

        try {
            konduto.analyze(orderToSend);
        } catch (KondutoInvalidEntityException | KondutoUnexpectedAPIResponseException e) {
            fail("analyze should succeed, but it failed: " + e.getMessage());
        }

        verify(postRequestedFor(urlMatching("/v1/orders")).withHeader("X-Requested-With",
                matching("Konduto Java SDK " + Konduto.VERSION)));

        assertEquals(ORDER_FROM_FILE.getScore(), orderToSend.getScore());
        assertEquals(ORDER_FROM_FILE.getRecommendation(), orderToSend.getRecommendation());
    }

    @Test
    public void analyzeInvalidOrderTest(){
        KondutoOrder order = new KondutoOrder();
        try {
            konduto.analyze(order);
            fail("KondutoInvalidEntityException should have been thrown");
        } catch (KondutoInvalidEntityException e) {
            // Expected
        } catch (KondutoUnexpectedAPIResponseException e) {
            fail("Expected KondutoInvalidEntityException, but got " + e.getClass().getName());
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
                        .withBody("{ \"order\": {\"old_status\":\"review\",\"new_status\":\"approved\"}}")));

        try {
            konduto.updateOrderStatus(ORDER_FROM_FILE, KondutoOrderStatus.APPROVED, "no comments");
        } catch (KondutoUnexpectedAPIResponseException e) {
            fail("order update should have succeeded, but it failed: " + e.getMessage());
        }

        verify(putRequestedFor(urlMatching("/v1/orders/" + ORDER_ID)).withHeader("X-Requested-With",
                matching("Konduto Java SDK " + Konduto.VERSION)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidStatusWhenUpdatingTest() throws KondutoUnexpectedAPIResponseException {
        konduto.updateOrderStatus(ORDER_FROM_FILE, KondutoOrderStatus.PENDING, "");
    }

    @Test(expected=NullPointerException.class)
    public void nullCommentsWhenUpdatingTest() throws KondutoUnexpectedAPIResponseException {
        konduto.updateOrderStatus(ORDER_FROM_FILE, KondutoOrderStatus.APPROVED, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidApiKeyTest() {
        new Konduto("invalid key");
    }
}