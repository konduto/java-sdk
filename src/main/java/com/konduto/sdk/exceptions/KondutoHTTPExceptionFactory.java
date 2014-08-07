package com.konduto.sdk.exceptions;

import org.apache.commons.httpclient.HttpStatus;
import org.json.JSONObject;

/**
 * Created by rsampaio on 01/08/14.
 */
public abstract class KondutoHTTPExceptionFactory {
	private static String responseBody;

	public static KondutoHTTPException buildException(int statusCode, String responseBody) {
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

	// 400
	protected static class KondutoHTTPBadRequestException extends KondutoHTTPException {
		public KondutoHTTPBadRequestException() {
			super("Your request is incorrect. Please review the parameters sent.", responseBody);
		}
	}

	// 401
	protected static class KondutoHTTPUnauthorizedException extends KondutoHTTPException {
		public KondutoHTTPUnauthorizedException() {
			super("Invalid API Key", responseBody);
		}
	}

	// 403
	protected static class KondutoHTTPForbiddenException extends KondutoHTTPException {
		public KondutoHTTPForbiddenException() {
			super("There are problems with your account. Please contact our support team.", responseBody);
		}
	}

	// 404
	protected static class KondutoHTTPNotFoundException extends KondutoHTTPException{
		public KondutoHTTPNotFoundException() {
			super("The requested resource could not be found.", responseBody);
		}
	}

	// 405
	protected static class KondutoHTTPMethodNotAllowedException extends KondutoHTTPException {
		public KondutoHTTPMethodNotAllowedException() {
			super("Sorry, we don't accept this HTTP method.", responseBody);
		}
	}

	// 422
	protected static class KondutoHTTPUnprocessableEntityException extends KondutoHTTPException {
		public KondutoHTTPUnprocessableEntityException() {
			super("Unprocessable entity", responseBody);
		}
	}

	// 429
	protected static class KondutoHTTPTooManyRequestsException extends KondutoHTTPException {
		public KondutoHTTPTooManyRequestsException() {
			super("Your free plan reached the transactions limit.", responseBody);
		}
	}

	// 500
	protected static class KondutoHTTPInternalErrorException extends KondutoHTTPException {
		public KondutoHTTPInternalErrorException() {
			super("Oh no...something wrong happened at our servers. Please contact our support team.", responseBody);
		}
	}

}
