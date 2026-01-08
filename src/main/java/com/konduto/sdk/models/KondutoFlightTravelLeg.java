package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

/**
 * Flight travel leg model.
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoFlightTravelLeg extends KondutoTravelLeg {

    /**
     * Default constructor.
     */
    public KondutoFlightTravelLeg() {
    }

    @ValidateFormat(format = "[A-Z]{3}")
    @Required
    private String originAirport;

    @ValidateFormat(format = "[A-Z]{3}")
    @Required
    private String destinationAirport;

    private String originCity;
    private String destinationCity;

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoFlightTravelLeg with(String attributeName, Object attributeValue) {
        return (KondutoFlightTravelLeg) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KondutoFlightTravelLeg that = (KondutoFlightTravelLeg) o;

        if (!originAirport.equals(that.originAirport)) return false;
        if (!destinationAirport.equals(that.destinationAirport)) return false;
        if (originCity != null ? !originCity.equals(that.originCity) : that.originCity != null) return false;
        return !(destinationCity != null ? !destinationCity.equals(that.destinationCity) : that.destinationCity != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + originAirport.hashCode();
        result = 31 * result + destinationAirport.hashCode();
        result = 31 * result + (originCity != null ? originCity.hashCode() : 0);
        result = 31 * result + (destinationCity != null ? destinationCity.hashCode() : 0);
        return result;
    }

    /**
     * Gets the origin airport.
     * @return the origin airport
     */
    public String getOriginAirport() {
        return originAirport;
    }

    /**
     * Sets the origin airport.
     * @param originAirport the origin airport
     */
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    /**
     * Gets the destination airport.
     * @return the destination airport
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * Sets the destination airport.
     * @param destinationAirport the destination airport
     */
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * Gets the origin city.
     * @return the origin city
     */
    public String getOriginCity() {
        return originCity;
    }

    /**
     * Sets the origin city.
     * @param originCity the origin city
     */
    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    /**
     * Gets the destination city.
     * @return the destination city
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * Sets the destination city.
     * @param destinationCity the destination city
     */
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
}
