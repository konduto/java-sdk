package com.konduto.sdk.models;

/**
 * Created by rsampaio on 06/08/14.
 */
public class KondutoGeolocation extends KondutoModel {

	/* Attributes */
	String city;
	String state;
	String country;

	/* Constructors */
	public KondutoGeolocation() { }

	/* Equals */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoGeolocation)) return false;

		KondutoGeolocation that = (KondutoGeolocation) o;

		if (city != null ? !city.equals(that.city) : that.city != null) return false;
		if (country != null ? !country.equals(that.country) : that.country != null) return false;
		if (state != null ? !state.equals(that.state) : that.state != null) return false;

		return true;
	}

	/* Getters and Setters */
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
}
