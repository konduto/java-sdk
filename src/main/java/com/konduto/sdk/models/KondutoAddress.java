package com.konduto.sdk.models;

/**
 *
 * Address model.
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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
