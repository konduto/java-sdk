package com.konduto.sdk.models;

import com.konduto.sdk.annotations.ValidateFormat;

/**
 * Model that represents the venue where an event will take place.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoEventVenue extends KondutoModel {

    private Integer capacity;

    private String name;

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
