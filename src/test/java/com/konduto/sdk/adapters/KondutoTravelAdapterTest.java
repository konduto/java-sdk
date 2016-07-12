package com.konduto.sdk.adapters;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.factories.KondutoPassengerFactory;
import com.konduto.sdk.factories.KondutoTravelLegFactory;
import com.konduto.sdk.models.KondutoBusTravelLeg;
import com.konduto.sdk.models.KondutoFlightTravelLeg;
import com.konduto.sdk.models.KondutoTravel;
import com.konduto.sdk.models.KondutoTravelType;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 08/05/15.
 *
 */
public class KondutoTravelAdapterTest {
    Type travelType = new TypeToken<KondutoTravel>(){}.getType();
    Type busTravelLegType = new TypeToken<KondutoBusTravelLeg>(){}.getType();
    Type flightTravelLegType = new TypeToken<KondutoFlightTravelLeg>(){}.getType();

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(travelType, new KondutoTravelAdapter())
            .registerTypeAdapter(busTravelLegType, new KondutoBusTravelLegAdapter())
            .registerTypeAdapter(flightTravelLegType, new KondutoFlightTravelLegAdapter())
            .create();

    JsonObject travelJson = (JsonObject) TestUtils.readJSONFromFile("travel.json");
    private static final KondutoTravel TRAVEL = new KondutoTravel();
    static {
        try {
            TRAVEL.setDepartureLeg(KondutoTravelLegFactory.departureFlight());
            TRAVEL.setReturnLeg(KondutoTravelLegFactory.returnFlight());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TRAVEL.setPassengers(KondutoPassengerFactory.passengersList());
        TRAVEL.setTravelType(KondutoTravelType.FLIGHT);
    }

    @Test
    public void deserializeTest(){
        assertEquals("deserialization failed", TRAVEL, gson.fromJson(travelJson, travelType));
    }
}
