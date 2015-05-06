package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

import java.util.Date;

/**
 * Created by raphaelsampaio on 5/6/15.
 *
 */
public class KondutoPassenger extends KondutoModel {

    /** Attributes */
    @Required
    private String name;

    @Required
    private String document;

    @Required
    private KondutoDocumentType documentType;

    @SerializedName("dob")
    private Date dateOfBirth;

    @ValidateFormat(format="\\w{2}")
    private String nationality;

    private boolean frequentTraveler;
    private boolean specialNeeds;
    private String loyaltyProgram;
    private String loyaltyCategory;

    /** Constructors */
    public KondutoPassenger() {}

    @Override
    public KondutoModel with(String attributeName, Object attributeValue) {
        return super.with(attributeName, attributeValue);
    }

    /** Equals and hashCode */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoPassenger that = (KondutoPassenger) o;

        if (frequentTraveler != that.frequentTraveler) return false;
        if (specialNeeds != that.specialNeeds) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (!document.equals(that.document)) return false;
        if (!documentType.equals(that.documentType)) return false;
        if (loyaltyCategory != null ? !loyaltyCategory.equals(that.loyaltyCategory) : that.loyaltyCategory != null)
            return false;
        if (loyaltyProgram != null ? !loyaltyProgram.equals(that.loyaltyProgram) : that.loyaltyProgram != null)
            return false;
        if (!name.equals(that.name)) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + document.hashCode();
        result = 31 * result + documentType.hashCode();
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (frequentTraveler ? 1 : 0);
        result = 31 * result + (specialNeeds ? 1 : 0);
        result = 31 * result + (loyaltyProgram != null ? loyaltyProgram.hashCode() : 0);
        result = 31 * result + (loyaltyCategory != null ? loyaltyCategory.hashCode() : 0);
        return result;
    }

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

    public KondutoDocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(KondutoDocumentType documentType) {
        this.documentType = documentType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isFrequentTraveler() {
        return frequentTraveler;
    }

    public void setFrequentTraveler(boolean frequentTraveler) {
        this.frequentTraveler = frequentTraveler;
    }

    public boolean isSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public String getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(String loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public String getLoyaltyCategory() {
        return loyaltyCategory;
    }

    public void setLoyaltyCategory(String loyaltyCategory) {
        this.loyaltyCategory = loyaltyCategory;
    }
}
