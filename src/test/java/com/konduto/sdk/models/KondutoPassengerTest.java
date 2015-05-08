package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoPassengerFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

/**
 */
public class KondutoPassengerTest {
    @Test
    public void isValidTest() {
        KondutoPassenger passenger = new KondutoPassenger();
        // invalid without name
        assertFalse(passenger.isValid());
        passenger.setName("Milton Tavares");
        // invalid without document
        assertFalse(passenger.isValid());
        passenger.setDocument("A1B2C3D4");
        // invalid without document type
        assertFalse(passenger.isValid());
        passenger.setDocumentType(KondutoDocumentType.PASSPORT);
        assertTrue(passenger.isValid());
        // invalid if nationality is not a 2-character string (e.g. "US")
        passenger.setNationality("123");
        assertFalse(passenger.isValid());
        passenger.setNationality("BR");
        assertTrue(passenger.isValid());
    }


    @Test
    public void serializeTest() throws Exception {
        JsonObject expectedJSON = (JsonObject) TestUtils.readJSONFromFile("passenger.json");
        JsonObject actualJSON = null;

        KondutoPassenger passenger = KondutoPassengerFactory.completePassenger();
        try {
            actualJSON = passenger.toJSON();
        } catch (KondutoInvalidEntityException e) {
            System.out.println(passenger.getErrors());
            fail("passenger should be valid");
        }

        assertEquals(expectedJSON, actualJSON);
    }

    @Test
    public void deserializeTest() throws Exception {
        JsonObject passengerJson = (JsonObject) TestUtils.readJSONFromFile("passenger.json");
        KondutoPassenger expectedPassenger = KondutoPassengerFactory.completePassenger();
        KondutoPassenger actualPassenger = (KondutoPassenger)
                KondutoModel.fromJSON(passengerJson, KondutoPassenger.class);
        assertEquals(expectedPassenger, actualPassenger);
    }
}
