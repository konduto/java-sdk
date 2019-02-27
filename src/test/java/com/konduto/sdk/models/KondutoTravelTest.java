package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.DateFormat;
import com.konduto.sdk.factories.KondutoPassengerFactory;
import com.konduto.sdk.factories.KondutoTravelLegFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static com.konduto.sdk.utils.TestUtils.getDateFrom;
import static org.junit.Assert.*;

/**
 * Created by rsampaio on 07/05/15.
 *
 */
public class KondutoTravelTest {
    private static final KondutoTravel TRAVEL = new KondutoTravel();

    {
        try {
            TRAVEL.setDepartureLeg(KondutoTravelLegFactory.departureFlight());
            TRAVEL.setReturnLeg(KondutoTravelLegFactory.returnFlight());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TRAVEL.setPassengers(KondutoPassengerFactory.passengersList());
        TRAVEL.setTravelType(KondutoTravelType.FLIGHT);
        TRAVEL.setExpirationDate(getDateFrom("2019-02-01T23:23:23Z",
                DateFormat.ISO_DATETIME));
    }

    private static final JsonObject TRAVEL_JSON =
            (JsonObject) TestUtils.readJSONFromFile("travel.json");


    @Test
    public void isValidTest() throws Exception {
        KondutoTravel travel = new KondutoTravel();
        // is invalid without type
        assertFalse(travel.isValid());
        travel.setTravelType(KondutoTravelType.FLIGHT);
        // is invalid without departure leg
        assertFalse(travel.isValid());
        KondutoFlightTravelLeg departureLeg = KondutoTravelLegFactory.departureFlight();
        travel.setDepartureLeg(departureLeg);
        // is invalid without passengers
        assertFalse(travel.isValid());
        List<KondutoPassenger> passengers = KondutoPassengerFactory.passengersList();
        travel.setPassengers(passengers);
        assertTrue(travel.isValid());
        // is valid with return leg
        KondutoFlightTravelLeg returnLeg = KondutoTravelLegFactory.returnFlight();
        travel.setReturnLeg(returnLeg);
        assertTrue(travel.isValid());
    }

    @Test
    public void serializeTest() throws Exception {
        assertEquals(TRAVEL_JSON, TRAVEL.toJSON());
    }

    @Test
    public void deserializeTest() throws Exception {
        assertEquals(KondutoModel.fromJSON(TRAVEL_JSON, KondutoTravel.class), TRAVEL);
    }

    @Test
    public void setExpirationDate() throws ParseException {
        String expectedDateAsString = "2019-01-01T13:30:03Z";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date expectedDate = sdf.parse(expectedDateAsString);
        TRAVEL.setExpirationDate(expectedDateAsString);
        assertEquals(expectedDateAsString, TRAVEL.getExpirationDate());
        TRAVEL.setExpirationDate(expectedDate);
        assertEquals(expectedDateAsString, TRAVEL.getExpirationDate());
        try {
            TRAVEL.setExpirationDate("2019-01-01 13:30:03");
            throw new RuntimeException("fail!");
        } catch(IllegalArgumentException exception) {
            // do nothing since the date was invalid
        }
    }
}
