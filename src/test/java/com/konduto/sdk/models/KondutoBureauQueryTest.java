package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class KondutoBureauQueryTest {
    private JsonParser jsonParser = new JsonParser();
    private static final String BUREAU_QUERY_AS_JSON_STRING =
        "{" +
            "\"service\": \"emailage\"," +
            "\"response\": {" +
                "\"advice\": \"Lower Fraud Risk\"," +
                "\"email_domain_exists\": true" +
            "}" +
        "}";
    private JsonObject bureauQueryAsJsonObject =
            (JsonObject) jsonParser.parse(BUREAU_QUERY_AS_JSON_STRING);

    @Test
    public void testBureauQueryDeserialization() {
        KondutoBureauQuery bureauQuery =
                (KondutoBureauQuery) KondutoModel.fromJSON(
                        bureauQueryAsJsonObject, KondutoBureauQuery.class);
        assertEquals("emailage", bureauQuery.getService());
        assertEquals("Lower Fraud Risk",
                bureauQuery.getAttribute("advice"));
        assertTrue((Boolean) bureauQuery.getAttribute("email_domain_exists"));
        assertNull(bureauQuery.getAttribute("email"));
    }
}
