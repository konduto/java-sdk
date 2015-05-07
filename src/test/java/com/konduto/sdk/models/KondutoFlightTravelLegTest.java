package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Created by rsampaio on 07/05/15.
 */
public class KondutoFlightTravelLegTest {
    private static final String ORIGIN_AIRPORT = "CGH";
    private static final String DESTINATION_AIRPORT = "SDU";
    private static final String TRAVEL_DATE = "2015-05-07";
    private static final String FARE_BASIS = "Y";
    private static final int NUMBER_OF_CONNECTIONS = 1;
    private static final KondutoTravelClass TRAVEL_CLASS = KondutoTravelClass.ECONOMY;

    private static final JsonObject FLIGHT_TRAVEL_LEG_AS_JSON = new JsonObject();
    static {
        FLIGHT_TRAVEL_LEG_AS_JSON.addProperty("origin_airport", ORIGIN_AIRPORT);
        FLIGHT_TRAVEL_LEG_AS_JSON.addProperty("destination_airport", DESTINATION_AIRPORT);
        FLIGHT_TRAVEL_LEG_AS_JSON.addProperty("date", TRAVEL_DATE);
        FLIGHT_TRAVEL_LEG_AS_JSON.addProperty("fare_basis", FARE_BASIS);
        FLIGHT_TRAVEL_LEG_AS_JSON.addProperty("number_of_connections", NUMBER_OF_CONNECTIONS);
        FLIGHT_TRAVEL_LEG_AS_JSON.addProperty("class", TRAVEL_CLASS.toString().toLowerCase());
    }

    private static final KondutoFlightTravelLeg FLIGHT_TRAVEL_LEG = new KondutoFlightTravelLeg();
    {
        FLIGHT_TRAVEL_LEG.setOriginAirport(ORIGIN_AIRPORT);
        FLIGHT_TRAVEL_LEG.setDestinationAirport(DESTINATION_AIRPORT);
        try {
            FLIGHT_TRAVEL_LEG.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(TRAVEL_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        FLIGHT_TRAVEL_LEG.setFareBasis(FARE_BASIS);
        FLIGHT_TRAVEL_LEG.setNumberOfConnections(NUMBER_OF_CONNECTIONS);
        FLIGHT_TRAVEL_LEG.setTravelClass(TRAVEL_CLASS);
    }



    @Test
    public void isValidTest() {
        KondutoFlightTravelLeg travelLeg = new KondutoFlightTravelLeg();
        assertFalse(travelLeg.isValid());
        // is invalid if airport IATA code is missing or not formed by 3 letters
        travelLeg.setOriginAirport("123");
        assertFalse(travelLeg.isValid());
        travelLeg.setOriginAirport("CGH");
        assertFalse(travelLeg.isValid());
        travelLeg.setDestinationAirport("123");
        assertFalse(travelLeg.isValid());
        travelLeg.setDestinationAirport("SDU");
        assertTrue(travelLeg.isValid());
    }

    @Test
    public void serializeTest() throws Exception {
        assertEquals(FLIGHT_TRAVEL_LEG_AS_JSON, FLIGHT_TRAVEL_LEG.toJSON());
    }

    @Test
    public void deserializeTest() {
        assertEquals(KondutoModel.fromJSON(FLIGHT_TRAVEL_LEG_AS_JSON, KondutoFlightTravelLeg.class),
                FLIGHT_TRAVEL_LEG);
    }

}
