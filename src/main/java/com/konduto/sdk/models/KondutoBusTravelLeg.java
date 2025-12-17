package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 * Bus travel leg model.
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoBusTravelLeg extends KondutoTravelLeg {
    @Required
    private String originCity;
    @Required
    private String destinationCity;

    /**
     * Default constructor.
     */
    public KondutoBusTravelLeg() {
    }

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

	/**
	 * Sets the origin city for the bus travel leg.
	 *
	 * @param originCity the origin city
	 */
    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

	/**
	 * Gets the destination city for the bus travel leg.
	 *
	 * @return the destination city
	 */
    public String getDestinationCity() {
        return destinationCity;
    }

	/**
	 * Sets the destination city for the bus travel leg.
	 *
	 * @param destinationCity the destination city
	 */
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
}
