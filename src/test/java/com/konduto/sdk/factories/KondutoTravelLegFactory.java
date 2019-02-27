package com.konduto.sdk.factories;

import com.konduto.sdk.DateFormat;
import com.konduto.sdk.models.KondutoFlightTravelLeg;
import com.konduto.sdk.models.KondutoTravelClass;

import java.text.ParseException;

import static com.konduto.sdk.utils.TestUtils.getDateFrom;

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
        kondutoFlightTravelLeg.setDate(getDateFrom("2015-05-07T12:40Z",
                DateFormat.ISO_DATETIME_NO_SECONDS));
        kondutoFlightTravelLeg.setFareBasis("Y");
        kondutoFlightTravelLeg.setCompany("Gol");
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
        kondutoFlightTravelLeg.setDate(getDateFrom("2015-05-08T15:00Z",
                DateFormat.ISO_DATETIME_NO_SECONDS));
        kondutoFlightTravelLeg.setFareBasis("Y");
        kondutoFlightTravelLeg.setCompany("Gol");
        return kondutoFlightTravelLeg;
    }

}
