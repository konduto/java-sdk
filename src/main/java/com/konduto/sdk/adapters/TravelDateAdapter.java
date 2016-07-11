package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.KondutoTravelLeg;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TravelDateAdapter implements JsonSerializer<KondutoTravelLeg.TravelDate>, JsonDeserializer<KondutoTravelLeg.TravelDate> {

    private static SimpleDateFormat travelDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

    static {
        travelDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }


    @Override
    public JsonElement serialize(KondutoTravelLeg.TravelDate src, Type typeOfSrc, JsonSerializationContext context) {
        String formattedDate = travelDateFormat.format(src);
        return new JsonPrimitive(formattedDate);
    }

    @Override
    public KondutoTravelLeg.TravelDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String element = json.getAsString();
        try {
            Date dateEl = travelDateFormat.parse(element);
            return KondutoTravelLeg.buildTravelDate(dateEl);
        } catch (ParseException e) {
            return null;
        }
    }
}