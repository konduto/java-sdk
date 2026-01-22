package com.konduto.sdk.models;

import com.konduto.sdk.annotations.ValidateFormat;

/**
 * Model that represents the venue where an event will take place.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoEventVenue extends KondutoModel {

    /**
     * Default constructor.
     */
    public KondutoEventVenue() {
    }

    private String name;

    private Integer capacity;

    private String address;

    private String city;

    private String state;

    @ValidateFormat(format = "[A-Za-z]{2}")
    private String country;

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoEventVenue with(String attributeName, Object attributeValue) {
        return (KondutoEventVenue) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KondutoEventVenue that = (KondutoEventVenue) o;

        return capacity != null && capacity.equals(that.capacity) &&
                name != null && name.equals(that.name) &&
                address != null && address.equals(that.address) &&
                city != null && city.equals(that.city) &&
                state != null && state.equals(that.state) &&
                country != null && country.equals(that.country);
    }

    /**
     * Gets the capacity.
     * @return the capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity.
     * @param capacity the capacity
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address.
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the city.
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the country.
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
