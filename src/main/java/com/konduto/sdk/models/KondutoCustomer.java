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
	private String taxId;
	private String phone1;
	private String phone2;
	@Required private String email;
	@SerializedName("new") private Boolean isNew;
	@SerializedName("vip") private Boolean isVip;

	private Date dob;
	@SerializedName("created_at") private Date createdAt;

	private String type;
	@SerializedName("risk_level") private String riskLevel;
	@SerializedName("risk_score") private Integer riskScore;
	@SerializedName("mother_name") private String motherName;

	/* Constructors */

	/**
	 * Default constructor.
	 */
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


		if (!id.equals(that.id)) return false;
		if (!name.equals(that.name)) return false;
		if (taxId != null ? !taxId.equals(that.taxId) : that.taxId != null) return false;
		if (phone1 != null ? !phone1.equals(that.phone1) : that.phone1 != null) return false;
		if (phone2 != null ? !phone2.equals(that.phone2) : that.phone2 != null) return false;
		if (!email.equals(that.email)) return false;
		if (isNew != null ? !isNew.equals(that.isNew) : that.isNew != null) return false;
		if (isVip != null ? !isVip.equals(that.isVip) : that.isVip != null) return false;
		if (!nullSafeAreDatesEqual(dob, that.dob)) return false;
		if (!nullSafeAreDatesEqual(createdAt, that.createdAt)) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;
		if (riskLevel != null ? !riskLevel.equals(that.riskLevel) : that.riskLevel != null) return false;
		if (riskScore != null ? !riskScore.equals(that.riskScore) : that.riskScore != null) return false;
		if (motherName != null ? !motherName.equals(that.motherName) : that.motherName != null) return false;

		return true;
	}

	/* Getters and Setters */

	/**
	 * Gets the customer's name.
	 *
	 * @return the customer's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the customer's name.
	 *
	 * @param name the customer's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the customer's unique identifier.
	 *
	 * @return the customer's ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the customer's unique identifier.
	 *
	 * @param id the customer's ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the customer's tax identification number.
	 *
	 * @return the customer's tax ID
	 */
	public String getTaxId() {
		return taxId;
	}

	/**
	 * Sets the customer's tax identification number.
	 *
	 * @param taxId the customer's tax ID
	 */
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	/**
	 * Gets the customer's primary phone number.
	 *
	 * @return the customer's primary phone number
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * Sets the customer's primary phone number.
	 *
	 * @param phone1 the customer's primary phone number
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * Gets the customer's secondary phone number.
	 *
	 * @return the customer's secondary phone number
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * Sets the customer's secondary phone number.
	 *
	 * @param phone2 the customer's secondary phone number
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	/**
	 * Gets the customer's email address.
	 *
	 * @return the customer's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the customer's email address.
	 *
	 * @param email the customer's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsVip() {
		return isVip;
	}

	/**
	 * Sets whether the customer is a VIP.
	 *
	 * @param isVip true if the customer is a VIP, false otherwise
	 */
	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	/**
	 * Gets whether the customer is new.
	 *
	 * @return true if the customer is new, false otherwise
	 */
	public Boolean getIsNew() {
		return isNew;
	}

	/**
	 * Sets whether the customer is new.
	 *
	 * @param isNew true if the customer is new, false otherwise
	 */
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	/**
	 * Gets the customer's creation date.
	 *
	 * @return the customer's creation date
	 */
	public Date getCreatedAt() { return createdAt; }

	/**
	 * Sets the customer's creation date.
	 *
	 * @param createdAt the customer's creation date
	 */
	public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

	/**
	 * Gets the customer's date of birth.
	 *
	 * @return the customer's date of birth
	 */
	public Date getDOB() { return dob; }

	/**
	 * Sets the customer's date of birth.
	 *
	 * @param dob the customer's date of birth
	 */
	public void setDOB(Date dob) { this.dob = dob; }

	/**
	 * Gets whether the customer is new (alias for getIsNew).
	 *
	 * @return true if the customer is new, false otherwise
	 */
	public Boolean getNew() {
		return isNew;
	}

	/**
	 * Sets whether the customer is new (alias for setIsNew).
	 *
	 * @param aNew true if the customer is new, false otherwise
	 */
	public void setNew(Boolean aNew) {
		isNew = aNew;
	}

	public Boolean getVip() {
		return isVip;
	}

	/**
	 * Sets whether the customer is a VIP (alias for setIsVip).
	 *
	 * @param vip true if the customer is a VIP, false otherwise
	 */
	public void setVip(Boolean vip) {
		isVip = vip;
	}

	/**
	 * Gets the customer's date of birth (alias for getDOB).
	 *
	 * @return the customer's date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the customer's date of birth (alias for setDOB).
	 *
	 * @param dob the customer's date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the customer's type.
	 *
	 * @return the customer's type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the customer's type.
	 *
	 * @param type the customer's type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the customer's risk level.
	 *
	 * @return the customer's risk level
	 */
	public String getRiskLevel() {
		return riskLevel;
	}

	/**
	 * Sets the customer's risk level.
	 *
	 * @param riskLevel the customer's risk level
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	/**
	 * Gets the customer's risk score.
	 *
	 * @return the customer's risk score
	 */
	public Integer getRiskScore() {
		return riskScore;
	}

	/**
	 * Sets the customer's risk score.
	 *
	 * @param riskScore the customer's risk score
	 */
	public void setRiskScore(Integer riskScore) {
		this.riskScore = riskScore;
	}

	/**
	 * Gets the customer's mother's name.
	 *
	 * @return the customer's mother's name
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * Sets the customer's mother's name.
	 *
	 * @param motherName the customer's mother's name
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
}
