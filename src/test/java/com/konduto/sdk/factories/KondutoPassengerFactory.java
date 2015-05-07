package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoDocumentType;
import com.konduto.sdk.models.KondutoPassenger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
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
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        passenger.setDateOfBirth(format.parse("1970-01-01"));
        passenger.setNationality("BR");
        passenger.setFrequentTraveler(true);
        passenger.setSpecialNeeds(false);
        passenger.setLoyaltyProgram("aadvantage");
        passenger.setLoyaltyCategory("gold");
        return passenger;
    }

    public static List<KondutoPassenger> passengersList() {
        KondutoPassenger milton = new KondutoPassenger();
        milton.setName("Milton Tavares");
        milton.setDocument("A1B2C3D4");
        milton.setDocumentType(KondutoDocumentType.PASSPORT);
        KondutoPassenger tom = basicPassenger();
        tom.setName("Milton Tavares");
        tom.setDocument("A1B2C3D4");
        tom.setDocumentType(KondutoDocumentType.PASSPORT);
        List<KondutoPassenger> passengers = new ArrayList<>();
        passengers.add(milton);
        passengers.add(tom);
        return passengers;
    }
}
