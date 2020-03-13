package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

import java.util.List;

/**
 * Model that represents an event.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoEvent extends KondutoModel {

    @Required
    private String name;

    @Required
    @ValidateFormat(
            format = "\\d{4}-(10|11|12|0\\d)-(30|31|[0-2]\\d)T(20|21|22|23|24|[0-1]?\\d):[0-5]?\\d(:[0-5]?\\d)?Z"
    )
    private String date;

    private KondutoEventType type;

    private String subtype;

    private KondutoEventVenue venue;

    private List<KondutoEventTicket> tickets;

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoEvent with(String attributeName, Object attributeValue) {
        return (KondutoEvent) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoEvent that = (KondutoEvent) o;

        if (!name.equals(that.name)) return false;
        return date.equals(that.date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public KondutoEventType getType() {
        return type;
    }

    public void setType(KondutoEventType type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public KondutoEventVenue getVenue() {
        return venue;
    }

    public void setVenue(KondutoEventVenue venue) {
        this.venue = venue;
    }

    public List<KondutoEventTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<KondutoEventTicket> tickets) {
        this.tickets = tickets;
    }
}
