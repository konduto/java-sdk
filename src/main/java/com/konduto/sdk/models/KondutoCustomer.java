package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;

/**
 * Created by rsampaio on 31/07/14.
 */
public final class KondutoCustomer extends KondutoModel {

	/* Attributes */

	@Required private String id;
	@Required private String name;
	@Required private String email;
	private String taxId;
	private String phone1;
	private String phone2;
	@SerializedName("vip") private Boolean isVip;
	@SerializedName("new") private Boolean isNew;

	/* Constructors */

	public KondutoCustomer() { }

	/* Equals */

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

	/* Getters and Setters */

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
