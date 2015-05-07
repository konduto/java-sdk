package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoFlightTravelLeg;
import com.konduto.sdk.models.KondutoTravelClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by rsampaio on 07/05/15.
 */
public class KondutoTravelLegFactory {
    public static KondutoFlightTravelLeg departureFlight() throws ParseException {
        KondutoFlightTravelLeg kondutoFlightTravelLeg = new KondutoFlightTravelLeg();
        kondutoFlightTravelLeg.setOriginAirport("CGH");
        kondutoFlightTravelLeg.setOriginCity("São Paulo");
        kondutoFlightTravelLeg.setDestinationAirport("SDU");
        kondutoFlightTravelLeg.setDestinationCity("Rio de Janeiro");
        kondutoFlightTravelLeg.setTravelClass(KondutoTravelClass.ECONOMY);
        kondutoFlightTravelLeg.setNumberOfConnections(0);
        kondutoFlightTravelLeg.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-05-07"));
        kondutoFlightTravelLeg.setFareBasis("Y");
        return kondutoFlightTravelLeg;
    }

    public static KondutoFlightTravelLeg returnFlight() throws ParseException {
        KondutoFlightTravelLeg kondutoFlightTravelLeg = new KondutoFlightTravelLeg();
        kondutoFlightTravelLeg.setOriginAirport("SDU");
        kondutoFlightTravelLeg.setOriginCity("Rio de Janeiro");
        kondutoFlightTravelLeg.setDestinationAirport("CGH");
        kondutoFlightTravelLeg.setDestinationCity("São Paulo");
        kondutoFlightTravelLeg.setTravelClass(KondutoTravelClass.ECONOMY);
        kondutoFlightTravelLeg.setNumberOfConnections(0);
        kondutoFlightTravelLeg.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-05-07"));
        kondutoFlightTravelLeg.setFareBasis("Y");
        return kondutoFlightTravelLeg;
    }

}
