package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 */
public class KondutoHTTPExceptionFactoryTest {
    private static final HashMap<Integer, Class<? extends KondutoException>> HTTP_STATUSES = new HashMap<>();

    static {
        HTTP_STATUSES.put(400, KondutoHTTPExceptionFactory.KondutoHTTPBadRequestException.class);
        HTTP_STATUSES.put(401, KondutoHTTPExceptionFactory.KondutoHTTPUnauthorizedException.class);
        HTTP_STATUSES.put(403, KondutoHTTPExceptionFactory.KondutoHTTPForbiddenException.class);
        HTTP_STATUSES.put(404, KondutoHTTPExceptionFactory.KondutoHTTPNotFoundException.class);
        HTTP_STATUSES.put(405, KondutoHTTPExceptionFactory.KondutoHTTPMethodNotAllowedException.class);
        HTTP_STATUSES.put(422,
                KondutoHTTPExceptionFactory.KondutoHTTPUnprocessableEntityException.class);
        HTTP_STATUSES.put(429, KondutoHTTPExceptionFactory.KondutoHTTPTooManyRequestsException.class);
        HTTP_STATUSES.put(500, KondutoHTTPExceptionFactory.KondutoHTTPInternalErrorException.class);
    }

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