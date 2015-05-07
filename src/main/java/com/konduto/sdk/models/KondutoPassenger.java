package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Passenger model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
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

    @SerializedName("dob") // format: yyyy-MM-dd (year-month-day)
    private Date dateOfBirth;

    @ValidateFormat(format="[A-Z]{2}") // e.g "BR", "US"
    private String nationality;

    private boolean frequentTraveler;
    private boolean specialNeeds;
    private Loyalty loyalty;

    private class Loyalty {
        private String program;
        private String category;
        public Loyalty(){}
    }

    /** Constructors */
    public KondutoPassenger() {}

    @Override
    public KondutoPassenger with(String attributeName, Object attributeValue) {
        return (KondutoPassenger) super.with(attributeName, attributeValue);
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
        if (getLoyaltyCategory() != null ? !getLoyaltyCategory().equals(that.getLoyaltyCategory()) : that.getLoyaltyCategory() != null)
            return false;
        if (getLoyaltyProgram() != null ? !getLoyaltyProgram().equals(that.getLoyaltyProgram()) : that.getLoyaltyProgram() != null)
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
        result = 31 * result + (getLoyaltyProgram() != null ? getLoyaltyProgram().hashCode() : 0);
        result = 31 * result + (getLoyaltyCategory() != null ? getLoyaltyCategory().hashCode() : 0);
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

    public boolean hasSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public String getLoyaltyProgram() {
        if(loyalty == null) { return null;}
        return loyalty.program;
    }

    public void setLoyaltyProgram(String loyaltyProgram) {
        if(loyalty == null) { loyalty = new Loyalty(); }
        loyalty.program = loyaltyProgram;
    }

    public String getLoyaltyCategory() {
        if(loyalty == null) { return null; }
        return loyalty.category;
    }

    public void setLoyaltyCategory(String loyaltyCategory) {
        if(loyalty == null) { loyalty = new Loyalty(); }
        this.loyalty.category = loyaltyCategory;
    }
}
