package com.konduto.sdk;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.konduto.sdk.exceptions.KondutoHTTPExceptionFactory;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.exceptions.KondutoUnexpectedAPIResponseException;
import com.konduto.sdk.models.KondutoModel;
import com.konduto.sdk.models.KondutoOrder;
import com.konduto.sdk.models.KondutoOrderStatus;
import com.konduto.sdk.models.KondutoRecommendation;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

/**
 * Main client class for interacting with the Konduto fraud prevention API.
 * Provides methods for analyzing orders, retrieving order information, and updating order status.
 */
public final class Konduto {
    private static final Properties PROPERTIES = new Properties();
    private static final ClassLoader contextClassLoader = Konduto.class.getClassLoader();
    private static final InputStream propertiesStream = contextClassLoader.getResourceAsStream("konduto.properties");

    static {
        if (propertiesStream != null) {
            try {
                PROPERTIES.load(propertiesStream);
                propertiesStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Properties stream is null. Context class loader: " + contextClassLoader);
        }
    }

    static final String VERSION = PROPERTIES.getProperty("version");

    private String apiKey;
    private JsonObject requestBody;
    private JsonObject responseBody;
    private URI endpoint = URI.create("https://api.konduto.com/v1");
    private HttpClient httpClient;

    /**
     * Creates a new Konduto client instance with the specified API key.
     *
     * @param apiKey the 21-character API key provided by Konduto
     * @throws IllegalArgumentException if the API key is null or not 21 characters long
     */
    public Konduto(String apiKey) {
        setApiKey(apiKey);
        rebuildHttpClient(null, null);
    }

    private void rebuildHttpClient(ProxySelector proxySelector, Authenticator proxyAuthenticator) {
        HttpClient.Builder builder = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10));
        if (proxySelector != null) {
            builder.proxy(proxySelector);
        }
        if (proxyAuthenticator != null) {
            builder.authenticator(proxyAuthenticator);
        }
        this.httpClient = builder.build();
    }

    public void setProxyHost(String proxyHost, int proxyPort) {
        rebuildHttpClient(ProxySelector.of(new InetSocketAddress(proxyHost, proxyPort)), null);
    }

    /**
     * Sets the proxy credentials for HTTP proxy authentication.
     *
     * @param username the proxy username
     * @param password the proxy password
     */
    public void setProxyCredentials(String username, String password) {
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        };
        rebuildHttpClient(null, authenticator);
    }

    /**
     * Sets a custom API endpoint URL. Useful for testing or using different environments.
     *
     * @param endpoint the URI of the Konduto API endpoint
     */
    public void setEndpoint(URI endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Sets the API key for authentication with Konduto services.
     *
     * @param apiKey the 21-character API key provided by Konduto
     * @throws IllegalArgumentException if the API key is null or not 21 characters long
     */
    public void setApiKey(String apiKey) {
        if (apiKey == null || apiKey.length() != 21) {
            throw new IllegalArgumentException("Illegal API Key: " + apiKey);
        }
        this.apiKey = apiKey;
    }

    /**
     * Returns debug information about the current request/response state.
     * Useful for troubleshooting API interactions.
     *
     * @return a string containing debug information including API key, endpoint, and request/response bodies
     */
    public String debug() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("API Key: %s\n", this.apiKey));
        sb.append(String.format("Endpoint: %s\n", this.endpoint.toString()));
        if (this.requestBody != null) {
            sb.append(String.format("Request body: %s\n", this.requestBody));
        }
        if (this.responseBody != null) {
            sb.append(String.format("Response body: %s\n", this.responseBody));
        }
        return sb.toString();
    }

    /**
     * Builds the URI for retrieving a specific order by ID.
     *
     * @param orderId the order identifier
     * @return the URI for the GET order request
     */
    protected URI kondutoGetOrderUrl(String orderId) {
        return URI.create(endpoint.toString().concat("/orders/" + orderId));
    }

    /**
     * Builds the URI for posting a new order analysis request.
     *
     * @return the URI for the POST order request
     */
    protected URI kondutoPostOrderUrl() {
        return URI.create(endpoint.toString().concat("/orders"));
    }

    /**
     * Builds the URI for updating an existing order.
     *
     * @param orderId the order identifier
     * @return the URI for the PUT order request
     */
    protected URI kondutoPutOrderUrl(String orderId) {
        return URI.create(endpoint.toString().concat("/orders/" + orderId));
    }

    private JsonObject sendRequest(HttpRequest request, JsonObject requestBodyForDebug) {
        try {
            this.requestBody = requestBodyForDebug;
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            this.responseBody = JsonParser.parseString(response.body()).getAsJsonObject();

            if (statusCode != 200) {
                throw new RuntimeException(KondutoHTTPExceptionFactory.buildException(statusCode, this.responseBody));
            }
            return this.responseBody;
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private HttpRequest.Builder newRequestBuilder(URI uri) {
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(apiKey.getBytes(StandardCharsets.UTF_8));
        return HttpRequest.newBuilder(uri)
                .header("Authorization", basicAuth)
                .header("X-Requested-With", "Konduto Java SDK " + VERSION)
                .header("Content-Type", "application/json");
    }

    public KondutoOrder getOrder(String orderId) throws KondutoUnexpectedAPIResponseException {
        HttpRequest request = newRequestBuilder(kondutoGetOrderUrl(orderId)).GET().build();
        JsonObject responseBody = sendRequest(request, null);

        if (responseBody == null) {
            throw new KondutoUnexpectedAPIResponseException(null);
        }
        if (responseBody.has("order")) {
            responseBody = responseBody.getAsJsonObject("order");
        }
        KondutoOrder order = (KondutoOrder) KondutoModel.fromJSON(responseBody, KondutoOrder.class);
        if (order.getId() == null) {
            order.setId(orderId);
        }
        return order;
    }

    /**
     * Analyzes an order for fraud risk using Konduto's fraud prevention service.
     * The order must be valid before analysis.
     *
     * @param order the KondutoOrder object to analyze
     * @throws KondutoInvalidEntityException if the order is not valid
     * @throws KondutoUnexpectedAPIResponseException if there's an unexpected API response
     */
    public void analyze(KondutoOrder order) throws KondutoInvalidEntityException, KondutoUnexpectedAPIResponseException {
        if (!order.isValid()) {
            throw new KondutoInvalidEntityException(order);
        }
        JsonObject orderJson = order.toJSON();
        HttpRequest request = newRequestBuilder(kondutoPostOrderUrl())
                .POST(HttpRequest.BodyPublishers.ofString(orderJson.toString()))
                .build();
        JsonObject responseBody = sendRequest(request, orderJson);

        if (responseBody == null) {
            throw new KondutoUnexpectedAPIResponseException(null);
        }
        if (responseBody.has("order")) {
            responseBody = responseBody.getAsJsonObject("order");
        }
        if (responseBody.has("status")) {
            order.setStatus(KondutoOrderStatus.valueOf(responseBody.get("status").getAsString().toUpperCase()));
        }
        if (responseBody.has("score")) {
            order.setScore(responseBody.get("score").getAsDouble());
        }
        if (responseBody.has("recommendation")) {
            order.setRecommendation(KondutoRecommendation.valueOf(responseBody.get("recommendation").getAsString().toUpperCase()));
        }
    }

    /**
     * Updates the status of an existing order in Konduto.
     * Only certain status transitions are allowed: APPROVED, DECLINED, FRAUD, NOT_AUTHORIZED, CANCELED.
     *
     * @param order the KondutoOrder object to update
     * @param newStatus the new status to set for the order
     * @param comments mandatory comments explaining the status change
     * @throws KondutoUnexpectedAPIResponseException if there's an unexpected API response
     * @throws IllegalArgumentException if the new status is not allowed
     * @throws NullPointerException if comments is null
     */
    public void updateOrderStatus(KondutoOrder order, KondutoOrderStatus newStatus, String comments) throws KondutoUnexpectedAPIResponseException {
        List<KondutoOrderStatus> allowed = Arrays.asList(KondutoOrderStatus.APPROVED, KondutoOrderStatus.DECLINED, KondutoOrderStatus.FRAUD, KondutoOrderStatus.NOT_AUTHORIZED, KondutoOrderStatus.CANCELED);
        if (!allowed.contains(newStatus)) {
            throw new IllegalArgumentException("Illegal status: " + newStatus);
        }
        if (comments == null) {
            throw new NullPointerException("comments cannot be null");
        }
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("status", newStatus.toString().toLowerCase());
        requestBody.addProperty("comments", comments);

        HttpRequest request = newRequestBuilder(kondutoPutOrderUrl(order.getId()))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        JsonObject responseBody = sendRequest(request, requestBody);

        if (responseBody == null || (responseBody.has("order") && (!responseBody.getAsJsonObject("order").has("old_status") || !responseBody.getAsJsonObject("order").has("new_status")))) {
            throw new KondutoUnexpectedAPIResponseException(responseBody);
        }

        order.setStatus(newStatus);
    }
}