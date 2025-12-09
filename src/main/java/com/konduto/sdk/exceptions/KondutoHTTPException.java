package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;

public class KondutoHTTPException extends KondutoException {
    private static final long serialVersionUID = -1L;
    private final int statusCode;
    private final JsonObject responseBody;

    public KondutoHTTPException(int statusCode, String message, JsonObject responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Construtor para compatibilidade com testes que não fornecem um status code.
     */
    public KondutoHTTPException(String message, JsonObject responseBody) {
        this(0, message, responseBody); // Define 0 como status code padrão
    }

    public int getStatusCode() {
        return statusCode;
    }

    public JsonObject getResponseBody() {
        return responseBody;
    }

    @Override
    public String getMessage() {
        return String.format("HTTP %d: %s - %s", statusCode, super.getMessage(), responseBody);
    }
}