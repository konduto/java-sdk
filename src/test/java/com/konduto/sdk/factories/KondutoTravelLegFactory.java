package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoFlightTravelLeg;
import com.konduto.sdk.models.KondutoTravelClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
        kondutoFlightTravelLeg.setDate(getDateFrom("2015-05-07T12:40Z"));
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
        kondutoFlightTravelLeg.setDate(getDateFrom("2015-05-08T15:00Z"));
        kondutoFlightTravelLeg.setFareBasis("Y");
        return kondutoFlightTravelLeg;
    }

    static Date getDateFrom(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
