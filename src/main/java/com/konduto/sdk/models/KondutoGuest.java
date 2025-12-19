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

	/**
	 * Default constructor.
	 */
	public KondutoGuest(){}

	/* Equals */

	/* Getters and Setters */
	/**
	 * Gets the name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the document.
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * Sets the document.
	 * @param document the document
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * Gets the document type.
	 * @return the document type
	 */
	public KondutoGuestDocumentType getDocumentType() {
		return documentType;
	}

	/**
	 * Sets the document type.
	 * @param documentType the document type
	 */
	public void setDocumentType(KondutoGuestDocumentType documentType) {
		this.documentType = documentType;
	}

	/**
	 * Gets the date of birth.
	 * @return the date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the date of birth.
	 * @param dob the date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the nationality.
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * Sets the nationality.
	 * @param nationality the nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}