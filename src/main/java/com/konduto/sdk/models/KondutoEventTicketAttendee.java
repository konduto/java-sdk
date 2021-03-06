package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

/**
 * Model representing an attendee to an event.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoEventTicketAttendee extends KondutoModel {

    @Required
    private String document;

    private KondutoEventTicketAttendeeDocumentType documentType;

    @SerializedName("dob")
    @ValidateFormat(format = "\\d{4}-(10|11|12|0\\d)-(30|31|[0-2]\\d)")
    private String dateOfBirth;

    private String name;

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoEventTicketAttendee with(String attributeName, Object attributeValue) {
        return (KondutoEventTicketAttendee) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof KondutoEventTicketAttendee)) { return false; }
        KondutoEventTicketAttendee that = (KondutoEventTicketAttendee) obj;
        return this.document != null && this.document.equals(that.document);
    }

    public KondutoEventTicketAttendeeDocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(KondutoEventTicketAttendeeDocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
