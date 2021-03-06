package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Travel leg model.
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public abstract class KondutoTravelLeg extends KondutoModel {

    /** Attributes */
    private Date date; // format: yyyy-MM-ddT2018-12-25T18:00Z
    private Integer numberOfConnections;
    @SerializedName(value="class")
    private KondutoTravelClass travelClass;
    private String fareBasis;
    private String company;

    /** Constructors */

    public KondutoTravelLeg() {
    }

    /**
     * Fluent constructor implementation
     *
     * @param attributeName  the attribute name (e.g greeting)
     * @param attributeValue the attribute value (e.g "Hello")
     * @return a new instance
     * @see <a href=http://en.wikipedia.org/wiki/Fluent_interface>Fluent interface article</a>
     */
    @Override
    public KondutoTravelLeg with(String attributeName, Object attributeValue) {
        return (KondutoTravelLeg) super.with(attributeName, attributeValue);
    }

    /** Equals and hashCode **/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoTravelLeg that = (KondutoTravelLeg) o;

        if (!numberOfConnections.equals(that.numberOfConnections)) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (travelClass != that.travelClass) return false;
        return !(fareBasis != null ? !fareBasis.equals(that.fareBasis) : that.fareBasis != null);

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + numberOfConnections;
        result = 31 * result + (travelClass != null ? travelClass.hashCode() : 0);
        result = 31 * result + (fareBasis != null ? fareBasis.hashCode() : 0);
        return result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumberOfConnections() {
        return numberOfConnections;
    }

    public void setNumberOfConnections(int numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }

    public KondutoTravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(KondutoTravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public String getFareBasis() {
        return fareBasis;
    }

    public void setFareBasis(String fareBasis) {
        this.fareBasis = fareBasis;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
