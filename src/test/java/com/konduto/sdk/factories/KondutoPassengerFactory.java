package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoDocumentType;
import com.konduto.sdk.models.KondutoPassenger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by raphaelsampaio on 5/6/15.
 *
 */
public class KondutoPassengerFactory {
    public static KondutoPassenger basicPassenger(){
        KondutoPassenger passenger = new KondutoPassenger();
        passenger.setName("Júlia da Silva");
        passenger.setDocument("A1B2C3D4");
        passenger.setDocumentType(KondutoDocumentType.ID);
        return passenger;
    }

    public static KondutoPassenger completePassenger() throws ParseException {
        KondutoPassenger passenger = basicPassenger();
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        passenger.setDateOfBirth(format.parse("1970-01-01"));
        passenger.setNationality("BR");
        passenger.setFrequentTraveler(true);
        passenger.setSpecialNeeds(false);
        passenger.setLoyaltyProgram("aadvantage");
        passenger.setLoyaltyCategory("gold");
        return passenger;
    }
}
