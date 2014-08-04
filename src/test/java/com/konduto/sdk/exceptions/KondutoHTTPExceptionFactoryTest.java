package com.konduto.sdk.exceptions;

import org.apache.commons.httpclient.HttpStatus;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rsampaio on 01/08/14.
 */
public class KondutoHTTPExceptionFactoryTest {
	private static final HashMap<Integer, Class> HTTP_STATUSES = new HashMap<Integer, Class>(){{
		put(HttpStatus.SC_BAD_REQUEST, KondutoHTTPExceptionFactory.KondutoHTTPBadRequestException.class);
		put(HttpStatus.SC_UNAUTHORIZED, KondutoHTTPExceptionFactory.KondutoHTTPUnauthorizedException.class);
		put(HttpStatus.SC_FORBIDDEN, KondutoHTTPExceptionFactory.KondutoHTTPForbiddenException.class);
		put(HttpStatus.SC_NOT_FOUND, KondutoHTTPExceptionFactory.KondutoHTTPNotFoundException.class);
		put(HttpStatus.SC_METHOD_NOT_ALLOWED, KondutoHTTPExceptionFactory.KondutoHTTPMethodNotAllowedException.class);
		put(HttpStatus.SC_UNPROCESSABLE_ENTITY,
				KondutoHTTPExceptionFactory.KondutoHTTPUnprocessableEntityException.class);
		put(429, KondutoHTTPExceptionFactory.KondutoHTTPTooManyRequestsException.class);
		put(HttpStatus.SC_INTERNAL_SERVER_ERROR, KondutoHTTPExceptionFactory.KondutoHTTPInternalErrorException.class);
	}};

	@Test
	public void buildExceptionTest() {
		for (Map.Entry<Integer, Class> entry : HTTP_STATUSES.entrySet()) {
			int statusCode = entry.getKey();
			JSONObject responseBody = new JSONObject();
			responseBody.put("status_code", statusCode);
			Class klass = entry.getValue();
			KondutoHTTPException exception = KondutoHTTPExceptionFactory.buildException(statusCode, responseBody);
			assertEquals(klass, exception.getClass());
		}
	}
}
