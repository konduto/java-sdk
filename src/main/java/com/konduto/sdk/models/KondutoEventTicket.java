package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 * Model that represents an event ticket.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoEventTicket extends KondutoModel {

    /**
     * Default constructor.
     */
    public KondutoEventTicket() {
    }

    private String id;

    @Required
    private KondutoEventTicketCategory category;

    @Required
    private Boolean premium;

    private String section;

    private KondutoEventTicketAttendee attendee;

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoEventTicket with(String attributeName, Object attributeValue) {
        return (KondutoEventTicket) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof KondutoEventTicket)) { return false; }
        KondutoEventTicket that = (KondutoEventTicket) obj;

        if (id == null || !id.equals(that.id)) return false;
        if (section == null || !section.equals(that.section)) return false;
        if (category == null || !category.equals(that.category)) return false;
        return attendee != null && attendee.equals(that.attendee);
    }

    @Override
    public boolean isValid() {
        if (attendee != null) return attendee.isValid() && super.isValid();
        return super.isValid();
    }

    /**
     * Gets the ticket ID.
     *
     * @return the ticket ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ticket ID.
     *
     * @param id the ticket ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the ticket category.
     *
     * @return the ticket category
     */
    public KondutoEventTicketCategory getCategory() {
        return category;
    }

    /**
     * Sets the ticket category.
     *
     * @param category the ticket category
     */
    public void setCategory(KondutoEventTicketCategory category) {
        this.category = category;
    }

    /**
     * Gets the ticket section.
     *
     * @return the ticket section
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets the ticket section.
     *
     * @param section the ticket section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Gets whether the ticket is premium.
     *
     * @return true if the ticket is premium, false otherwise
     */
    public Boolean getPremium() {
        return premium;
    }

    /**
     * Sets whether the ticket is premium.
     *
     * @param premium true if the ticket is premium, false otherwise
     */
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    /**
     * Gets the ticket attendee information.
     *
     * @return the ticket attendee
     */
    public KondutoEventTicketAttendee getAttendee() {
        return attendee;
    }

    /**
     * Sets the ticket attendee information.
     *
     * @param attendee the ticket attendee
     */
    public void setAttendee(KondutoEventTicketAttendee attendee) {
        this.attendee = attendee;
    }
}
