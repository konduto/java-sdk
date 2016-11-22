package com.konduto.sdk.models;

import java.util.Date;

/**
 *
 * Konduto Guest.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoGuest extends KondutoModel {
	private String name;
	private String document;

	private KondutoGuestDocumentType documentType;

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;

		KondutoGuest that = (KondutoGuest) object;

		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (document != null ? !document.equals(that.document) : that.document != null) return false;
		if (documentType != null ? !documentType.equals(that.documentType) : that.documentType != null) return false;
		if (dob != null ? !dob.equals(that.dob) : that.dob != null) return false;
		if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;

		return true;
	}

	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (document != null ? document.hashCode() : 0);
		result = 31 * result + (documentType != null ? documentType.hashCode() : 0);
		result = 31 * result + (dob != null ? dob.hashCode() : 0);
		result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
		return result;
	}

	private Date dob;
	private String nationality;

	public KondutoGuest(){}

	/* Equals */

	/* Getters and Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public KondutoGuestDocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(KondutoGuestDocumentType documentType) {
		this.documentType = documentType;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}