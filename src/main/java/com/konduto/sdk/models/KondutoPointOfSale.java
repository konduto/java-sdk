package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

import java.util.Objects;

/**
 *
 * Address model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoPointOfSale extends KondutoModel {

	/* Attributes */

	@Required
	private String id = "1";
	@Required private String name;
	private Double lat;
	private Double lon;

	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;

	/* Constructors */

	public KondutoPointOfSale() { }

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoPointOfSale with(String attributeName, Object attributeValue) {
		return (KondutoPointOfSale) super.with(attributeName, attributeValue);
	}

	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoPointOfSale)) return false;

		KondutoPointOfSale that = (KondutoPointOfSale) o;

		// required
		if (!id.equals(that.id)) return false;
		if (!name.equals(that.name)) return false;

		// optional
		if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
		if (lon != null ? !lon.equals(that.lon) : that.lon != null) return false;
		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (city != null ? !city.equals(that.city) : that.city != null) return false;
		if (state != null ? !state.equals(that.state) : that.state != null) return false;
		if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
		if (country != null ? !country.equals(that.country) : that.country != null) return false;

		return true;
	}

	/* Getters and Setters */

	public String getId() {return id;}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLat() {return lat;}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
