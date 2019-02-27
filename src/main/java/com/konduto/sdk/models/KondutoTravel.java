package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;

import java.util.Collection;
import java.util.Date;

/**
 * KondutoTravel model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoTravel extends KondutoModel {
    @Required
    @SerializedName(value = "type")
    private KondutoTravelType travelType;
    @Required
    @SerializedName(value = "departure")
    private KondutoTravelLeg departureLeg;
    @SerializedName(value = "return")
    private KondutoTravelLeg returnLeg;
    @Required
    private Collection<KondutoPassenger> passengers;
    private String expirationDate;

    /** Constructors */
    public KondutoTravel(){}

    /**
     * Fluent constructor implementation
     *
     * @param attributeName  the attribute name (e.g greeting)
     * @param attributeValue the attribute value (e.g "Hello")
     * @return a new instance
     * @see <a href=http://en.wikipedia.org/wiki/Fluent_interface>Fluent interface article</a>
     */
    @Override
    public KondutoTravel with(String attributeName, Object attributeValue) {
        return (KondutoTravel) super.with(attributeName, attributeValue);
    }

    /** Equals and hashCode */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoTravel that = (KondutoTravel) o;

        if (travelType != that.travelType) return false;
        if (!departureLeg.equals(that.departureLeg)) return false;
        if (returnLeg != null ? !returnLeg.equals(that.returnLeg) : that.returnLeg != null) return false;
        return passengers.equals(that.passengers);

    }

    @Override
    public int hashCode() {
        int result = travelType.hashCode();
        result = 31 * result + departureLeg.hashCode();
        result = 31 * result + (returnLeg != null ? returnLeg.hashCode() : 0);
        result = 31 * result + passengers.hashCode();
        return result;
    }

    /** Getters/setters */

    public KondutoTravelType getTravelType() {
        return travelType;
    }

    public void setTravelType(KondutoTravelType travelType) {
        this.travelType = travelType;
    }

    public KondutoTravelLeg getDepartureLeg() {
        return departureLeg;
    }

    public void setDepartureLeg(KondutoTravelLeg departureLeg) {
        this.departureLeg = departureLeg;
    }

    public KondutoTravelLeg getReturnLeg() {
        return returnLeg;
    }

    public void setReturnLeg(KondutoTravelLeg returnLeg) {
        this.returnLeg = returnLeg;
    }

    public Collection<KondutoPassenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Collection<KondutoPassenger> passengers) {
        this.passengers = passengers;
    }

    public Date getExpirationDate() {
        return deserializeDate(expirationDate);
    }

    void setExpirationDate(Date expirationDate) {
        this.expirationDate = serializeDate(expirationDate
        );
    }
}
