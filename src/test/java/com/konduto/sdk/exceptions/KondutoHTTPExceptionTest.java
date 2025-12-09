package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 */
public class KondutoHTTPExceptionTest {

    private class KondutoFakeHTTPException extends KondutoHTTPException {
        private static final long serialVersionUID = -2329739425820280221L;

        protected KondutoFakeHTTPException(String message, JsonObject responseBody) {
            super(message, responseBody);
        }
    }

    @Test
    public void constructorTest(){
        String message = "fake message";
        JsonObject json = new JsonObject();
        KondutoFakeHTTPException fakeException = new KondutoFakeHTTPException(message, json);
        // Ajusta a asserção para o formato de mensagem correto, que inclui o status code.
        assertEquals(String.format("HTTP 0: %s - %s", message, json), fakeException.getMessage());
    }
}