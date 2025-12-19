package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;

/**
 * Exception thrown when an HTTP error occurs during API communication.
 */
public class KondutoHTTPException extends KondutoException {
    private static final long serialVersionUID = -1L;
    private final int statusCode;
    private final JsonObject responseBody;

    /**
     * Constructs a new KondutoHTTPException with the specified status code, message, and response body.
     * @param statusCode the HTTP status code
     * @param message the error message
     * @param responseBody the response body as a JsonObject
     */
    public KondutoHTTPException(int statusCode, String message, JsonObject responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Construtor para compatibilidade com testes que não fornecem um status code.
     * @param message the error message
     * @param responseBody the response body as a JsonObject
     */
    public KondutoHTTPException(String message, JsonObject responseBody) {
        this(0, message, responseBody); // Define 0 como status code padrão
    }

    /**
     * Gets the HTTP status code.
     * @return the HTTP status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Gets the response body.
     * @return the response body as a JsonObject
     */
    public JsonObject getResponseBody() {
        return responseBody;
    }

    @Override
    public String getMessage() {
        return String.format("HTTP %d: %s - %s", statusCode, super.getMessage(), responseBody);
    }
}