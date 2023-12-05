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

	public Date getCreatedAt() { return createdAt; }

	public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

	public Date getDOB() { return dob; }

	public void setDOB(Date dob) { this.dob = dob; }

	public Boolean getNew() {
		return isNew;
	}

	public void setNew(Boolean aNew) {
		isNew = aNew;
	}

	public Boolean getVip() {
		return isVip;
	}

	public void setVip(Boolean vip) {
		isVip = vip;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Integer getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(Integer riskScore) {
		this.riskScore = riskScore;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
}
