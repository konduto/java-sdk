package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoVehicleFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class KondutoVehicleTest {
    @Test
    public void serializeTest() {
        JsonObject expectedJSON = (JsonObject) TestUtils.readJSONFromFile("vehicle.json");

        KondutoVehicle vehicle = KondutoVehicleFactory.getVehicle();

        try {
            vehicle.isValid();
            assertEquals(expectedJSON, vehicle.toJSON());
        } catch (KondutoInvalidEntityException e) {
            fail("address should be valid");
        }
    }
}
