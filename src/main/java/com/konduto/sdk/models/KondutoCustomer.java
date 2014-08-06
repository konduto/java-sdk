package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;

/**
 * Created by rsampaio on 31/07/14.
 */
public final class KondutoCustomer extends KondutoModel {
	private String id;
	private String name;
	private String email;
	private String taxId;
	private String phone1;
	private String phone2;
	private Boolean isVip;
	private Boolean isNew;

	public KondutoCustomer() { }

	@Override
	public boolean isValid() {
		errors.clear();
		if(id == null) { isRequiredError("id"); }
		if(name == null) { isRequiredError("name"); }
		if(email == null) { isRequiredError("email"); }
		return errors.isEmpty();
	}

	@Override
	public JSONObject toJSON() throws KondutoInvalidEntityException {
		if(!this.isValid()){ throw new KondutoInvalidEntityException(this); }
		JSONObject json = new JSONObject();
		json.put("id", this.id);
		json.put("name", this.name);
		json.put("email", this.email);
		json.put("tax_id", this.taxId);
		json.put("phone1", this.phone1);
		json.put("phone2", this.phone2);
		json.put("is_vip", this.isVip);
		json.put("is_new", this.isNew);
		return json;
	}

	public KondutoCustomer(JSONObject json) {
		// required
		this.id = json.getString("id");
		this.name = json.getString("name");
		this.email = json.getString("email");

		// optional
		if(json.has("tax_id")) { this.taxId = json.getString("tax_id"); }
		if(json.has("phone1")) { this.phone1 = json.getString("phone1"); }
		if(json.has("phone2")) { this.phone2 = json.getString("phone2"); }
		if(json.has("is_new")) { this.isNew = json.getBoolean("is_new"); }
		if(json.has("is_vip")) { this.isVip = json.getBoolean("is_vip"); }
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoCustomer)) return false;

		KondutoCustomer that = (KondutoCustomer) o;

		// required
		if (!id.equals(that.id)) return false;
		if (!email.equals(that.email)) return false;
		if (!name.equals(that.name)) return false;

		// optional
		if (isNew != null ? !isNew.equals(that.isNew) : that.isNew != null) return false;
		if (isVip != null ? !isVip.equals(that.isVip) : that.isVip != null) return false;
		if (phone1 != null ? !phone1.equals(that.phone1) : that.phone1 != null) return false;
		if (phone2 != null ? !phone2.equals(that.phone2) : that.phone2 != null) return false;
		if (taxId != null ? !taxId.equals(that.taxId) : that.taxId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (taxId != null ? taxId.hashCode() : 0);
		result = 31 * result + (phone1 != null ? phone1.hashCode() : 0);
		result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (isVip != null ? isVip.hashCode() : 0);
		result = 31 * result + (isNew != null ? isNew.hashCode() : 0);
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
}
