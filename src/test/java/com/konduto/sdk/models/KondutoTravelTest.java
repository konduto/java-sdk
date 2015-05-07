package com.konduto.sdk.models;

import com.konduto.sdk.factories.KondutoPassengerFactory;
import com.konduto.sdk.factories.KondutoTravelLegFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rsampaio on 07/05/15.
 */
public class KondutoTravelTest {
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

    // TODO: serialize/deserialize tests

}
