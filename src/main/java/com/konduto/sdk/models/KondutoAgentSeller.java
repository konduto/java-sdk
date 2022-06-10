package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

import java.util.Date;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 03/06/2022.
 * Agent Seller model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public final class KondutoAgentSeller extends KondutoModel {

	/* Attributes */

	@Required private String id = "1";
	private String login;
	@Required private String name;
	private String taxId;
	private Date dob;
	private String category;
	private Date created_at;

	/* Constructors */

	public KondutoAgentSeller() { }

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoAgentSeller with(String attributeName, Object attributeValue) {
		return (KondutoAgentSeller) super.with(attributeName, attributeValue);
	}

	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoAgentSeller)) return false;

		KondutoAgentSeller that = (KondutoAgentSeller) o;

		// required
		if (!id.equals(that.id)) return false;
		if (!name.equals(that.name)) return false;

		// optional
		if (login !=null ? !login.equals(that.login) : that.login != null) return false;
		if (taxId != null ? !taxId.equals(that.taxId) : that.taxId != null) return false;
		if (category != null ? !category.equals(that.category) : that.category != null) return false;
		if (!nullSafeAreDatesEqual(created_at, that.created_at)){
			return false;
		}
		if (!nullSafeAreDatesEqual(dob, that.dob)){
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getCreated_at() { return created_at; }

	public void setCreated_at(Date created_at) { this.created_at = created_at; }

	public Date getDOB() { return dob; }

	public void setDOB(Date dob) { this.dob = dob; }
}
