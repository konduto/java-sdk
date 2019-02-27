package com.konduto.sdk.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.konduto.sdk.models.KondutoTravelLeg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by rsampaio on 7/12/16.
 *
 */
class KondutoTravelLegAdapter {
    static final SimpleDateFormat TRAVEL_LEG_DATE_FORMAT= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    static { TRAVEL_LEG_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC")); }

    void setLegDate(String jsonDate, KondutoTravelLeg travelLeg) {
        try {
            Date parsedDate = TRAVEL_LEG_DATE_FORMAT.parse(jsonDate);
            travelLeg.setDate(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    JsonElement serialize(KondutoTravelLeg travelLeg) {
        JsonObject json = new JsonObject();
        if(travelLeg.getFareBasis() != null) {
            json.addProperty("fare_basis", travelLeg.getFareBasis());
        }
        if(travelLeg.getNumberOfConnections() != null) {
            json.addProperty("number_of_connections", travelLeg.getNumberOfConnections());
        }
        if(travelLeg.getDate() != null) {
            json.addProperty("date", TRAVEL_LEG_DATE_FORMAT.format(travelLeg.getDate()));
        }
        if(travelLeg.getTravelClass() != null) {
            json.addProperty("class", travelLeg.getTravelClass().toString().toLowerCase());
        }
        if(travelLeg.getCompany() != null) {
            json.addProperty("company", travelLeg.getCompany());
        }

        return json;
    }
}
