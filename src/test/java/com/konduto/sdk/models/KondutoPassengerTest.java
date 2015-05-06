package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoPassengerFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by raphaelsampaio on 5/6/15.
 */
public class KondutoPassengerTest {
    @Test
    public void serializeTest() throws ParseException {
        JsonObject expectedJSON = (JsonObject) TestUtils.readJSONFromFile("passenger.json");
        JsonObject actualJSON = null;

        KondutoPassenger passenger = KondutoPassengerFactory.completePassenger();
        try {
            actualJSON = passenger.toJSON();
        } catch (KondutoInvalidEntityException e) {
            System.out.println(passenger.getErrors());
            fail("address should be valid");
        }

        System.out.println(actualJSON);
    }
}
