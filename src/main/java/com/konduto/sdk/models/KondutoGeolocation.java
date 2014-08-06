package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;

/**
 * Created by rsampaio on 06/08/14.
 */
public class KondutoGeolocation extends KondutoModel {
	String city;
	String state;
	String country;

	public KondutoGeolocation() { }

	@Override
	public boolean isValid() {
		return true;
	}

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

	@Override
	public int hashCode() {
		int result = city != null ? city.hashCode() : 0;
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (country != null ? country.hashCode() : 0);
		return result;
	}

	@Override
	public JSONObject toJSON() throws KondutoInvalidEntityException {
		if(!this.isValid()){ throw new KondutoInvalidEntityException(this); }
		JSONObject json = new JSONObject();
		if(this.city != null) json.put("city", this.city);
		if(this.state != null) json.put("state", this.state);
		if(this.country != null) json.put("country", this.country);
		return json;
	}

	public KondutoGeolocation(JSONObject json) {
		if(json != null) {
			if (json.has("city")) this.city = json.getString("city");
			if (json.has("state")) this.state = json.getString("state");
			if (json.has("country")) this.country = json.getString("country");
		}
	}

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
