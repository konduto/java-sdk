package com.konduto.sdk.factories;

import com.konduto.sdk.models.*;

import java.util.Arrays;

public class KondutoEventFactory {

    public static KondutoEvent getSingleEvent() {
        return new KondutoEvent()
                .with("name", "Safadão no Maracanã")
                .with("date", "2021-01-01T03:00:00Z")
                .with("type", KondutoEventType.SHOW)
                .with("subtype", "sertanejo")
                .with(
                        "venue",
                        new KondutoEventVenue()
                                .with("name", "Estádio do Maracanã")
                                .with("capacity", 80000)
                                .with("address", "Av. Maracanã s/n")
                                .with("city", "Rio de Janeiro")
                                .with("state", "RJ")
                                .with("country", "BR")
                )
                .with(
                        "tickets",
                        Arrays.asList(
                                new KondutoEventTicket()
                                        .with("category", KondutoEventTicketCategory.REGULAR)
                                        .with("premium", true)
                                        .with("section", "Pista Premium")
                                        .with(
                                                "attendee",
                                                new KondutoEventTicketAttendee()
                                                .with("document","12345678900")
                                                .with("documentType", KondutoEventTicketAttendeeDocumentType.CPF)
                                                .with("dateOfBirth", "1990-10-28")
                                        ),
                                new KondutoEventTicket()
                                        .with("category", KondutoEventTicketCategory.STUDENT)
                                        .with("premium", false)

                        )
                );
    }

}


