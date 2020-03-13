package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoVehicleFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoVehicleTest {

    private KondutoVehicle fullVehicle;
    private static JsonObject expectedJSON;

    @BeforeClass
    public static void initializeJson() {
        expectedJSON = (JsonObject) TestUtils.readJSONFromFile("vehicle.json");
    }

    @Before
    public void restartVehicle() {
        fullVehicle = KondutoVehicleFactory.getVehicle();
    }

    @Test
    public void serializeTest() throws KondutoInvalidEntityException {
        assertEquals(expectedJSON, fullVehicle.toJSON());
    }

    @Test(expected = KondutoInvalidEntityException.class)
    public void invalidVid() throws KondutoInvalidEntityException {
        fullVehicle
                .with(
                        "vid",
                        "invalid vid (contains space AND is larger than 17 alphanumeric)"
                )
                .toJSON();
    }

    @Test(expected = KondutoInvalidEntityException.class)
    public void invalidOwner() throws KondutoInvalidEntityException {
        fullVehicle
                .with("owner", new KondutoVehicleOwner())
                .toJSON();
    }

    @Test(expected = KondutoInvalidEntityException.class)
    public void renavamLargerThanExpected() throws KondutoInvalidEntityException {
        fullVehicle
                .with("renavam", "12312312312312312312312312312312312312312312312312312312312")
                .toJSON();
    }

    @Test(expected = KondutoInvalidEntityException.class)
    public void renavamSmallerThanExpected() throws KondutoInvalidEntityException {
        fullVehicle
                .with("renavam", "11")
                .toJSON();
    }


    @Test(expected = KondutoInvalidEntityException.class)
    public void incompleteVehicle() throws KondutoInvalidEntityException {
        fullVehicle
                .with("make", null)
                .with("model", null)
                .toJSON();
    }
}
