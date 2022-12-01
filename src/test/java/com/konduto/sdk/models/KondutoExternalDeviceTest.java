package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoExternalDeviceFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class KondutoExternalDeviceTest {
    @Test
    public void serializeTest(){
        KondutoExternalDevice externalDevice = KondutoExternalDeviceFactory.getExternalDevice();
        JsonObject externalDeviceJSON = (JsonObject) TestUtils.readJSONFromFile("external_device.json");

        try {
            assertEquals("serialization failed", externalDeviceJSON, externalDevice.toJSON());
        } catch (KondutoInvalidEntityException e) {
            fail("device should be valid");
        }

        assertEquals("deserialization failed", KondutoModel.fromJSON(externalDeviceJSON, KondutoExternalDevice.class), externalDevice);

    }
}
