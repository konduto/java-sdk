package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

import java.util.Date;

/**
 * Represents an agent seller in the Konduto system.
 * This class extends KondutoModel and contains agent seller specific attributes.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public final class KondutoAgentSeller extends KondutoModel {

	/* Attributes */

	@Required private String id;
	private String login;
	@Required private String name;
	private String taxId;
	private Date dob;
	private String category;
	private Date created_at;

	/* Constructors */

	/**
	 * Default constructor for KondutoAgentSeller.
	 */
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

	/**
	 * Gets the agent seller's name.
	 *
	 * @return the agent seller name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the agent seller's name.
	 *
	 * @param name the agent seller name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the agent seller's unique identifier.
	 *
	 * @return the agent seller ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the agent seller's unique identifier.
	 *
	 * @param id the agent seller ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the agent seller's tax ID.
	 *
	 * @return the tax ID
	 */
	public String getTaxId() {
		return taxId;
	}

	/**
	 * Sets the agent seller's tax ID.
	 *
	 * @param taxId the tax ID
	 */
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	/**
	 * Gets the agent seller's category.
	 *
	 * @return the agent seller category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the agent seller's category.
	 *
	 * @param category the agent seller category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the agent seller's login username.
	 *
	 * @return the login username
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the agent seller's login username.
	 *
	 * @param login the login username
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the agent seller's creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreated_at() { return created_at; }

	/**
	 * Sets the agent seller's creation date.
	 *
	 * @param created_at the creation date
	 */
	public void setCreated_at(Date created_at) { this.created_at = created_at; }

	/**
	 * Gets the agent seller's date of birth.
	 *
	 * @return the date of birth
	 */
	public Date getDOB() { return dob; }

	/**
	 * Sets the agent seller's date of birth.
	 *
	 * @param dob the date of birth
	 */
	public void setDOB(Date dob) { this.dob = dob; }
}
