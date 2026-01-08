package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

import java.util.List;

/**
 * Model that represents an event.
/**
 * Event model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoEvent extends KondutoModel {

    /**
     * Default constructor.
     */
    public KondutoEvent() {
    }

    @Required
    private String name;

    @Required
    @ValidateFormat(
            format = "\\d{4}-(10|11|12|0\\d)-(30|31|[0-2]\\d)T(20|21|22|23|24|[0-1]?\\d):[0-5]?\\d(:[0-5]?\\d)?Z"
    )
    private String date;

    @Required
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

    @Override
    public boolean isValid() {
        boolean isValid = true;
        if (tickets != null) {
            for (KondutoEventTicket ticket : tickets) {
                isValid &= ticket.isValid();
            }
        }

        return isValid && super.isValid();
    }

	/**
	 * Gets the event name.
	 *
	 * @return the event name
	 */
    public String getName() {
        return name;
    }

	/**
	 * Sets the event name.
	 *
	 * @param name the event name
	 */
    public void setName(String name) {
        this.name = name;
    }

	/**
	 * Gets the event date.
	 *
	 * @return the event date
	 */
    public String getDate() {
        return date;
    }

	/**
	 * Sets the event date.
	 *
	 * @param date the event date
	 */
    public void setDate(String date) {
        this.date = date;
    }

	/**
	 * Gets the event type.
	 *
	 * @return the event type
	 */
    public KondutoEventType getType() {
        return type;
    }

	/**
	 * Sets the event type.
	 *
	 * @param type the event type
	 */
    public void setType(KondutoEventType type) {
        this.type = type;
    }

	/**
	 * Gets the event subtype.
	 *
	 * @return the event subtype
	 */
    public String getSubtype() {
        return subtype;
    }

	/**
	 * Sets the event subtype.
	 *
	 * @param subtype the event subtype
	 */
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

	/**
	 * Gets the event venue.
	 *
	 * @return the event venue
	 */
    public KondutoEventVenue getVenue() {
        return venue;
    }

	/**
	 * Sets the event venue.
	 *
	 * @param venue the event venue
	 */
    public void setVenue(KondutoEventVenue venue) {
        this.venue = venue;
    }

	/**
	 * Gets the list of event tickets.
	 *
	 * @return the list of event tickets
	 */
    public List<KondutoEventTicket> getTickets() {
        return tickets;
    }

	/**
	 * Sets the list of event tickets.
	 *
	 * @param tickets the list of event tickets
	 */
    public void setTickets(List<KondutoEventTicket> tickets) {
        this.tickets = tickets;
    }
}
