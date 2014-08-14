package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;
import org.apache.commons.httpclient.HttpStatus;

/**
 *
 * This factory is able to, given a status code,
 * build a {@link com.konduto.sdk.exceptions.KondutoHTTPException} child exception.
 *
 */
public abstract class KondutoHTTPExceptionFactory {
	private static JsonObject responseBody;

	/**
	 *
	 * @param statusCode the HTTP status code answered by Konduto's API.
	 * @param responseBody the response body.
	 * @return an exception corresponding to the HTTP status code.
	 */
	public static KondutoHTTPException buildException(int statusCode, JsonObject responseBody) {
		KondutoHTTPExceptionFactory.responseBody = responseBody;
		switch(statusCode) {
			case HttpStatus.SC_BAD_REQUEST:
				return new KondutoHTTPBadRequestException();
			case HttpStatus.SC_UNAUTHORIZED:
				return new KondutoHTTPUnauthorizedException();
			case HttpStatus.SC_FORBIDDEN:
				return new KondutoHTTPForbiddenException();
			case HttpStatus.SC_NOT_FOUND:
				return new KondutoHTTPNotFoundException();
			case HttpStatus.SC_METHOD_NOT_ALLOWED:
				return new KondutoHTTPMethodNotAllowedException();
			case HttpStatus.SC_UNPROCESSABLE_ENTITY:
				return new KondutoHTTPUnprocessableEntityException();
			case 429: // not available via HttpStatus enum
				return new KondutoHTTPTooManyRequestsException();
			case HttpStatus.SC_INTERNAL_SERVER_ERROR:
				return new KondutoHTTPInternalErrorException();
		}
		return null;
	}

	/**
	 * HTTP 400 is answered when the client sent a bad request to Konduto's API.
	 */
	protected static class KondutoHTTPBadRequestException extends KondutoHTTPException {
		public KondutoHTTPBadRequestException() {
			super("Your request is incorrect. Please review the parameters sent.", responseBody);
		}
	}

	/**
	 * HTTP 401 is answered when Konduto's API fails to authenticate the merchant.
	 */
	protected static class KondutoHTTPUnauthorizedException extends KondutoHTTPException {
		public KondutoHTTPUnauthorizedException() {
			super("Invalid API Key", responseBody);
		}
	}

	/**
	 * HTTP 403 is answered when the merchant is not authorized to use Konduto's API.
	 */
	protected static class KondutoHTTPForbiddenException extends KondutoHTTPException {
		public KondutoHTTPForbiddenException() {
			super("There are problems with your account. Please contact our support team.", responseBody);
		}
	}

	/**
	 * HTTP 404 is answered when the resource is not found by Konduto's API.
	 */
	protected static class KondutoHTTPNotFoundException extends KondutoHTTPException{
		public KondutoHTTPNotFoundException() {
			super("The requested resource could not be found.", responseBody);
		}
	}

	/**
	 * HTTP 405 is answered when the HTTP method is not allowed by Konduto's API.
	 */
	protected static class KondutoHTTPMethodNotAllowedException extends KondutoHTTPException {
		public KondutoHTTPMethodNotAllowedException() {
			super("Sorry, we don't accept this HTTP method.", responseBody);
		}
	}

	/**
	 * HTTP 422 is RFU
	 */
	protected static class KondutoHTTPUnprocessableEntityException extends KondutoHTTPException {
		public KondutoHTTPUnprocessableEntityException() {
			super("Unprocessable entity", responseBody);
		}
	}

	/**
	 * HTTP 429 is answered when a merchant who signed up for a free plan reaches the transaction limit.
	 */
	protected static class KondutoHTTPTooManyRequestsException extends KondutoHTTPException {
		public KondutoHTTPTooManyRequestsException() {
			super("Your free plan reached the transactions limit.", responseBody);
		}
	}

	/**
	 * HTTP 500 is answered when an internal error happens at Konduto's API.
	 */
	protected static class KondutoHTTPInternalErrorException extends KondutoHTTPException {
		public KondutoHTTPInternalErrorException() {
			super("Oh no...something wrong happened at our servers. Please contact our support team.", responseBody);
		}
	}

}
