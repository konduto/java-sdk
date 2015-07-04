package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 */
public class KondutoHTTPExceptionFactoryTest {
	private static final HashMap<Integer, Class<? extends KondutoException>> HTTP_STATUSES = new HashMap<Integer, Class<? extends KondutoException>>();
	
	static {
		HTTP_STATUSES.put(HttpStatus.SC_BAD_REQUEST, KondutoHTTPExceptionFactory.KondutoHTTPBadRequestException.class);
		HTTP_STATUSES.put(HttpStatus.SC_UNAUTHORIZED, KondutoHTTPExceptionFactory.KondutoHTTPUnauthorizedException.class);
		HTTP_STATUSES.put(HttpStatus.SC_FORBIDDEN, KondutoHTTPExceptionFactory.KondutoHTTPForbiddenException.class);
		HTTP_STATUSES.put(HttpStatus.SC_NOT_FOUND, KondutoHTTPExceptionFactory.KondutoHTTPNotFoundException.class);
		HTTP_STATUSES.put(HttpStatus.SC_METHOD_NOT_ALLOWED, KondutoHTTPExceptionFactory.KondutoHTTPMethodNotAllowedException.class);
		HTTP_STATUSES.put(HttpStatus.SC_UNPROCESSABLE_ENTITY,
				KondutoHTTPExceptionFactory.KondutoHTTPUnprocessableEntityException.class);
		HTTP_STATUSES.put(429, KondutoHTTPExceptionFactory.KondutoHTTPTooManyRequestsException.class);
		HTTP_STATUSES.put(HttpStatus.SC_INTERNAL_SERVER_ERROR, KondutoHTTPExceptionFactory.KondutoHTTPInternalErrorException.class);
	};

	@Test
	public void buildExceptionTest() {
		for (Map.Entry<Integer, Class<? extends KondutoException>> entry : HTTP_STATUSES.entrySet()) {
			int statusCode = entry.getKey();
			JsonObject responseBody = new JsonObject();
			responseBody.addProperty("status_code", statusCode);
			Class<? extends KondutoException> klass = entry.getValue();
			KondutoHTTPException exception = KondutoHTTPExceptionFactory.buildException(statusCode, responseBody);
			assertEquals(klass, exception.getClass());
		}
	}
}
