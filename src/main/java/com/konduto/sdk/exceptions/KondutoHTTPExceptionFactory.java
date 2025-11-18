package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;

/**
 *
 * This factory is able to, given a status code,
 * build a {@link com.konduto.sdk.exceptions.KondutoHTTPException} child exception.
 *
 */
public abstract class KondutoHTTPExceptionFactory {

    /**
     *
     * @param statusCode the HTTP status code answered by Konduto's API.
     * @param responseBody the response body.
     * @return an exception corresponding to the HTTP status code.
     */
    public static KondutoHTTPException buildException(int statusCode, JsonObject responseBody) {
        switch(statusCode) {
            case 400:
                return new KondutoHTTPBadRequestException(responseBody);
            case 401:
                return new KondutoHTTPUnauthorizedException(responseBody);
            case 403:
                return new KondutoHTTPForbiddenException(responseBody);
            case 404:
                return new KondutoHTTPNotFoundException(responseBody);
            case 405:
                return new KondutoHTTPMethodNotAllowedException(responseBody);
            case 422:
                return new KondutoHTTPUnprocessableEntityException(responseBody);
            case 429:
                return new KondutoHTTPTooManyRequestsException(responseBody);
            case 500:
                return new KondutoHTTPInternalErrorException(responseBody);
            default:
                return new KondutoHTTPException(statusCode, "Unexpected HTTP status code", responseBody);
        }
    }

    /**
     * HTTP 400 is answered when the client sent a bad request to Konduto's API.
     */
    protected static class KondutoHTTPBadRequestException extends KondutoHTTPException {
        public KondutoHTTPBadRequestException(JsonObject responseBody) {
            super(400, "Your request is incorrect. Please review the parameters sent.", responseBody);
        }
    }

    /**
     * HTTP 401 is answered when Konduto's API fails to authenticate the merchant.
     */
    protected static class KondutoHTTPUnauthorizedException extends KondutoHTTPException {
        public KondutoHTTPUnauthorizedException(JsonObject responseBody) {
            super(401, "Invalid API Key", responseBody);
        }
    }

    /**
     * HTTP 403 is answered when the merchant is not authorized to use Konduto's API.
     */
    protected static class KondutoHTTPForbiddenException extends KondutoHTTPException {
        public KondutoHTTPForbiddenException(JsonObject responseBody) {
            super(403, "There are problems with your account. Please contact our support team.", responseBody);
        }
    }

    /**
     * HTTP 404 is answered when the resource is not found by Konduto's API.
     */
    protected static class KondutoHTTPNotFoundException extends KondutoHTTPException{
        public KondutoHTTPNotFoundException(JsonObject responseBody) {
            super(404, "The requested resource could not be found.", responseBody);
        }
    }

    /**
     * HTTP 405 is answered when the HTTP method is not allowed by Konduto's API.
     */
    protected static class KondutoHTTPMethodNotAllowedException extends KondutoHTTPException {
        public KondutoHTTPMethodNotAllowedException(JsonObject responseBody) {
            super(405, "Sorry, we don't accept this HTTP method.", responseBody);
        }
    }

    /**
     * HTTP 422 is RFU
     */
    protected static class KondutoHTTPUnprocessableEntityException extends KondutoHTTPException {
        public KondutoHTTPUnprocessableEntityException(JsonObject responseBody) {
            super(422, "Unprocessable entity", responseBody);
        }
    }

    /**
     * HTTP 429 is answered when a merchant who signed up for a free plan reaches the transaction limit.
     */
    protected static class KondutoHTTPTooManyRequestsException extends KondutoHTTPException {
        public KondutoHTTPTooManyRequestsException(JsonObject responseBody) {
            super(429, "Your free plan reached the transactions limit.", responseBody);
        }
    }

    /**
     * HTTP 500 is answered when an internal error happens at Konduto's API.
     */
    protected static class KondutoHTTPInternalErrorException extends KondutoHTTPException {
        public KondutoHTTPInternalErrorException(JsonObject responseBody) {
            super(500, "Oh no...something wrong happened at our servers. Please contact our support team.", responseBody);
        }
    }
}