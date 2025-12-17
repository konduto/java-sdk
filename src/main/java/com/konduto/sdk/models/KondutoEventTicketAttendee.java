package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

/**
 * Model that represents an event ticket attendee.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoEventTicketAttendee extends KondutoModel {

    /**
     * Default constructor.
     */
    public KondutoEventTicketAttendee() {
    }

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

    /**
     * Gets the document type of the attendee.
     *
     * @return the document type
     */
    public KondutoEventTicketAttendeeDocumentType getDocumentType() {
        return documentType;
    }

    /**
     * Sets the document type of the attendee.
     *
     * @param documentType the document type
     */
    public void setDocumentType(KondutoEventTicketAttendeeDocumentType documentType) {
        this.documentType = documentType;
    }

    /**
     * Gets the date of birth of the attendee.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the attendee.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the document number of the attendee.
     *
     * @return the document number
     */
    public String getDocument() {
        return document;
    }

    /**
     * Sets the document number of the attendee.
     *
     * @param document the document number
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * Gets the name of the attendee.
     *
     * @return the attendee name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the attendee.
     *
     * @param name the attendee name
     */
    public void setName(String name) {
        this.name = name;
    }
}
