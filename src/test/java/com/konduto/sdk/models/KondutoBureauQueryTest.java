package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class KondutoBureauQueryTest {
    JsonObject expectedQuery = new JsonObject();
    KondutoBureauQuery bureauQuery = new KondutoBureauQuery();

    @Before
    public void setUp() {
        expectedQuery.addProperty("service", "emailage");
        JsonObject expectedResponse = new JsonObject();
        expectedResponse.addProperty("advice", "Lower Fraud Risk");
        expectedResponse.addProperty("email_domain_exists", true);
        expectedQuery.add("response", expectedResponse);

        bureauQuery.setService(KondutoBureauService.EMAIL_AGE);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(KondutoBureauResponseField.ADVICE.toString().toLowerCase(), "Lower " +
                "Fraud Risk");
        response.put(KondutoBureauResponseField.EMAIL_DOMAIN_EXISTS.toString().toLowerCase(), true);
        bureauQuery.setResponse(response);
    }

    @Test
    public void testBureauQuerySerialization() throws KondutoInvalidEntityException {
        assertEquals(expectedQuery, bureauQuery.toJSON());
    }

    @Test
    public void testBureauQueryDeserialization() throws KondutoInvalidEntityException {
        System.out.println(bureauQuery.toJSON());
        System.out.println(KondutoBureauQuery.fromJSON(bureauQuery.toJSON(),
                KondutoBureauQuery.class));
    }
}
