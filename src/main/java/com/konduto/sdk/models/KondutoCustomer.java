package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;

import java.util.Date;

/**
 *
 * Customer model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public final class KondutoCustomer extends KondutoModel {

	/* Attributes */

	@Required private String id = "1";
	@Required private String name;
	@Required private String email;
	private String taxId;
	private String phone1;
	private String phone2;
	@SerializedName("vip") private Boolean isVip;
	@SerializedName("new") private Boolean isNew;

	private Date created_at;

	/* Constructors */

	public KondutoCustomer() { }

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoCustomer with(String attributeName, Object attributeValue) {
		return (KondutoCustomer) super.with(attributeName, attributeValue);
	}

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
		if (!nullSafeAreDatesEqual(created_at, that.created_at)){
			return false;
		}


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

	public Date getCreated_at() { return created_at; }

	public void setCreated_at(Date created_at) { this.created_at = created_at; }
}
