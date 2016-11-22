package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;

/**
 *
 * Device model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoHotel extends KondutoModel {

	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String category;

	private Collection<KondutoHotelRoom> rooms;

	public KondutoHotel(){}

	/* Equals */
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;

		KondutoHotel that = (KondutoHotel) object;

		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
		if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
		if (city != null ? !city.equals(that.city) : that.city != null) return false;
		if (state != null ? !state.equals(that.state) : that.state != null) return false;
		if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
		if (country != null ? !country.equals(that.country) : that.country != null) return false;
		if (category != null ? !category.equals(that.category) : that.category != null) return false;
		if (rooms != null ? !rooms.equals(that.rooms) : that.rooms != null) return false;

		return true;
	}

	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address1 != null ? address1.hashCode() : 0);
		result = 31 * result + (address2 != null ? address2.hashCode() : 0);
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (zip != null ? zip.hashCode() : 0);
		result = 31 * result + (country != null ? country.hashCode() : 0);
		result = 31 * result + (category != null ? category.hashCode() : 0);
		result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
		return result;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Collection<KondutoHotelRoom> getRooms() {
		return rooms;
	}

	public void setRooms(Collection<KondutoHotelRoom> rooms) {
		this.rooms = rooms;
	}
}