package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoHotel;
import com.konduto.sdk.models.KondutoHotelRoom;
import com.konduto.sdk.models.KondutoGuest;
import com.konduto.sdk.models.KondutoGuestDocumentType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by andre on 21/11/16.
 */
public class KondutoHotelFactory {

    public static KondutoGuest getGuest(String name, String document, KondutoGuestDocumentType documentType,
                                        Date dob, String nationality) {
        KondutoGuest guest = new KondutoGuest();
        guest.setName(name);
        guest.setDocument(document);
        guest.setDocumentType(documentType);
        guest.setDob(dob);
        guest.setNationality(nationality);
        return guest;
    }

    public static KondutoHotel getHotel() throws ParseException {
        KondutoHotelRoom hotelRoom = new KondutoHotelRoom();
        hotelRoom.setNumber("123");
        hotelRoom.setCode("321");
        hotelRoom.setType("");
        hotelRoom.setCheckinDate(new Date(1428410400000L));
        hotelRoom.setCheckoutDate(new Date(1431002400000L));
        hotelRoom.setNumberOfGuests(2);
        hotelRoom.setBoardBasis("board_basis");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<KondutoGuest> guests = new ArrayList<KondutoGuest>();
        guests.add(getGuest("Turista Sobrenome", "123456678-90", KondutoGuestDocumentType.CPF,
                sdf.parse("01/01/1980"), "BR"));

        guests.add(getGuest("Outro Turista", "923456678-90", KondutoGuestDocumentType.CPF,
                sdf.parse("01/01/1985"), "BR"));

        hotelRoom.setGuests(guests);

        KondutoHotelRoom hotelRoom2 = new KondutoHotelRoom();
        hotelRoom2.setNumber("456");
        hotelRoom2.setCode("987");
        hotelRoom2.setType("");
        hotelRoom2.setCheckinDate(new Date(1462624800000L));
        hotelRoom2.setCheckoutDate(new Date(1467722400000L));
        hotelRoom2.setNumberOfGuests(2);
        hotelRoom2.setBoardBasis("another_board_basis");

        guests = new ArrayList<KondutoGuest>();
        guests.add(getGuest("Viajante Sobrenome", "123456678-90", KondutoGuestDocumentType.CPF,
                sdf.parse("01/01/1990"), "BR"));

        guests.add(getGuest("Outro Viajante", "923456678-90", KondutoGuestDocumentType.CPF,
                sdf.parse("01/01/1991"), "BR"));

        hotelRoom2.setGuests(guests);

        ArrayList<KondutoHotelRoom> rooms = new ArrayList<KondutoHotelRoom>();
        rooms.add(hotelRoom);
        rooms.add(hotelRoom2);

        KondutoHotel hotel = new KondutoHotel();
        hotel.setName("Not A Fraud Hotel");
        hotel.setRooms(rooms);
        hotel.setAddress1("Rua de Exemplo, 123");
        hotel.setAddress2("Avenida Exemplar, 456");
        hotel.setCity("Sao Paulo");
        hotel.setState("Sao Paulo");
        hotel.setZip("12345-678");
        hotel.setCountry("Brasil");
        hotel.setCategory("Hotel");

        return hotel;
    }
}