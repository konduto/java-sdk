package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 */
public class KondutoBusTravelLeg extends KondutoTravelLeg {
    @Required
    private String originCity;
    @Required
    private String destinationCity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KondutoBusTravelLeg that = (KondutoBusTravelLeg) o;

        if (!originCity.equals(that.originCity)) return false;
        return destinationCity.equals(that.destinationCity);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + originCity.hashCode();
        result = 31 * result + destinationCity.hashCode();
        return result;
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
