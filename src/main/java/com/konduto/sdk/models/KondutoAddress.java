package com.konduto.sdk.models;

/**
 * Represents an address in the Konduto system.
 * This class extends KondutoModel and contains address-related attributes such as street, city, and postal code.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoAddress extends KondutoModel {

	/* Attributes */

	private String name;
	private String address1;
	private String address2;
	private String zip;
	private String city;
	private String state;
	private String country;

	/* Constructors */

	/**
	 * Default constructor for KondutoAddress.
	 */
	public KondutoAddress() { }

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoAddress with(String attributeName, Object attributeValue) {
		return (KondutoAddress) super.with(attributeName, attributeValue);
	}

	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof KondutoAddress)) return false;

		KondutoAddress that = (KondutoAddress) o;

		if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
		if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
		if (city != null ? !city.equals(that.city) : that.city != null) return false;
		if (country != null ? !country.equals(that.country) : that.country != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (state != null ? !state.equals(that.state) : that.state != null) return false;
		if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;

		return true;
	}

	/* Getters and Setters */

	/**
	 * Gets the name associated with this address.
	 *
	 * @return the address name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name associated with this address.
	 *
	 * @param name the address name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the first address line.
	 *
	 * @return the first address line
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the first address line.
	 *
	 * @param address1 the first address line
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the second address line.
	 *
	 * @return the second address line
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the second address line.
	 *
	 * @param address2 the second address line
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the postal code/ZIP code.
	 *
	 * @return the postal code
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the postal code/ZIP code.
	 *
	 * @param zip the postal code
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the city name.
	 *
	 * @return the city name
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city name.
	 *
	 * @param city the city name
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state/province name.
	 *
	 * @return the state name
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state/province name.
	 *
	 * @param state the state name
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country name.
	 *
	 * @return the country name
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country name.
	 *
	 * @param country the country name
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
