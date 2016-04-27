package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * KondutoTravelAdapter to deserialize KondutoTravel objects.
 *
 */
public class KondutoTravelAdapter implements JsonDeserializer<KondutoTravel> {

    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
     * for any non-trivial field of the returned object. However, you should never invoke it on the
     * the same type passing {@code json} since that will cause an infinite loop (Gson will call your
     * call-back method again).
     *
     * @param je    The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context
     * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     */
    @Override
    public KondutoTravel deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject json = (JsonObject) je;
        KondutoTravel travel = new KondutoTravel();
        String travelTypeAsStr = json.get("type").getAsString().toUpperCase();
        KondutoTravelType travelType = KondutoTravelType.valueOf(travelTypeAsStr);
        JsonObject departureJson = json.getAsJsonObject("departure");
        JsonObject returnJson = json.has("return") ? json.getAsJsonObject("return") : null;

        switch (travelType) {
            case BUS:
                travel.setDepartureLeg((KondutoTravelLeg)
                        KondutoModel.fromJSON(departureJson, KondutoBusTravelLeg.class));
                if(returnJson != null) {
                    travel.setReturnLeg((KondutoTravelLeg)
                            KondutoModel.fromJSON(returnJson, KondutoBusTravelLeg.class));
                }
                break;
            case FLIGHT:
                travel.setDepartureLeg((KondutoTravelLeg)
                        KondutoModel.fromJSON(departureJson, KondutoFlightTravelLeg.class));
                if(returnJson != null) {
                    travel.setReturnLeg((KondutoTravelLeg)
                            KondutoModel.fromJSON(returnJson, KondutoFlightTravelLeg.class));
                }
                break;
        }

        JsonArray passengersJsonArray = json.getAsJsonArray("passengers");
        List<KondutoPassenger> passengers = new ArrayList<KondutoPassenger>();
        for(JsonElement jsonObject : passengersJsonArray) {
            KondutoPassenger passenger = (KondutoPassenger)
                    KondutoModel.fromJSON((JsonObject) jsonObject, KondutoPassenger.class);
            passengers.add(passenger);
        }

        travel.setPassengers(passengers);
        travel.setTravelType(travelType);
        return travel;
    }
}
