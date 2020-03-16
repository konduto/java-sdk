package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 * Model that represents an event ticket.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoEventTicket extends KondutoModel {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KondutoEventTicketCategory getCategory() {
        return category;
    }

    public void setCategory(KondutoEventTicketCategory category) {
        this.category = category;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public KondutoEventTicketAttendee getAttendee() {
        return attendee;
    }

    public void setAttendee(KondutoEventTicketAttendee attendee) {
        this.attendee = attendee;
    }
}
