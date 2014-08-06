package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;

/**
 * Created by rsampaio on 05/08/14.
 */
public class KondutoAddress extends KondutoModel {

	private String name;
	private String address1;
	private String address2;
	private String zip;
	private KondutoGeolocation geolocation;

	public KondutoAddress() { super(); }

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public JSONObject toJSON() throws KondutoInvalidEntityException {
		if(!isValid()) { throw new KondutoInvalidEntityException(this); }
		JSONObject json = new JSONObject();
		if(this.name != null) json.put("name", this.name);
		if(this.address1 != null) json.put("address1", this.address1);
		if(this.address2 != null) json.put("address2", this.address2);
		if(this.geolocation != null) {
			if(this.geolocation.getCity() != null) json.put("city", this.geolocation.getCity());
			if(this.geolocation.getState() != null) json.put("state", this.geolocation.getState());
			if(this.geolocation.getCountry() != null) json.put("country", this.geolocation.getCountry());
		}
		if(this.zip != null) json.put("zip", this.zip);
		return json;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoAddress)) return false;

		KondutoAddress that = (KondutoAddress) o;

		if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
		if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
		if (geolocation != null ? !geolocation.equals(that.geolocation) : that.geolocation != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (address1 != null ? address1.hashCode() : 0);
		result = 31 * result + (address2 != null ? address2.hashCode() : 0);
		result = 31 * result + (zip != null ? zip.hashCode() : 0);
		result = 31 * result + (geolocation != null ? geolocation.hashCode() : 0);
		return result;
	}

	public KondutoAddress(JSONObject json) {
		if(json != null) {
			if(json.has("name")) this.name = json.getString("name");
			if(json.has("address1")) this.address1 = json.getString("address1");
			if(json.has("address2")) this.address2 = json.getString("address2");
			if(json.has("zip")) this.zip = json.getString("zip");
			if(json.has("city") || json.has("state") || json.has("country")) {
				this.geolocation = new KondutoGeolocation(json);
			} else if(json.has("geolocation")) {
				this.geolocation = new KondutoGeolocation(json.getJSONObject("geolocation"));
			}
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city){
		if(this.geolocation == null) { this.geolocation = new KondutoGeolocation(); }
		this.geolocation.setCity(city);
	}

	public void setState(String state){
		if(this.geolocation == null) { this.geolocation = new KondutoGeolocation(); }
		this.geolocation.setState(state);
	}

	public void setCountry(String country){
		if(this.geolocation == null) { this.geolocation = new KondutoGeolocation(); }
		this.geolocation.setCountry(country);
	}

	public void getCity(){
		this.geolocation.getCity();
	}

	public void getState(){
		this.geolocation.getState();
	}

	public void getCountry(){
		this.geolocation.getCountry();
	}

}
