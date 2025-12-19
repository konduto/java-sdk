package com.konduto.sdk.models;

/**
 * Represents geolocation information in the Konduto system.
 * This class extends KondutoModel and contains location attributes such as city, state, and country.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoGeolocation extends KondutoModel {

	/* Attributes */
	String city;
	String state;
	String country;

	/* Constructors */
	/**
	 * Default constructor.
	 */
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
}
