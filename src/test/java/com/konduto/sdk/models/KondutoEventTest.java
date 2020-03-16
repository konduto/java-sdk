package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoEventFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoEventTest {

    private KondutoEvent singleEvent;
    private static JsonObject expectedJSON;

    @BeforeClass
    public static void initializeJson() {
        expectedJSON = (JsonObject) TestUtils.readJSONFromFile("event.json");
    }

    @Before
    public void restartEvent() {
        singleEvent = KondutoEventFactory.getSingleEvent();
    }

    @Test
    public void serializeTest() throws KondutoInvalidEntityException {
        assertEquals(expectedJSON, singleEvent.toJSON());
    }
}
