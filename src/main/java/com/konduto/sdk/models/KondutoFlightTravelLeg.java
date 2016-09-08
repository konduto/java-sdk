package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

/**
 * Flight travel leg model.
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoFlightTravelLeg extends KondutoTravelLeg {
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

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
}
