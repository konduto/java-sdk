package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Abstract base class for bank accounts in the Konduto system.
 * This class extends KondutoModel and provides common bank account attributes.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public abstract class KondutoBank extends KondutoModel {

    /**
     * Attributes
     * <p>
     * id
     * key_type	(ENUM).
     * key_value.
     * holder_name.
     * holder_tax_id.
     * bank_code.
     * bank_name.
     * bank_branch.
     * bank_account.
     * balance.
     * amount.
     */

    private String id;
    @SerializedName("key_type")
    private KondutoBankDocumentType keyType;
    @SerializedName("key_value")
    private String keyValue;
    @SerializedName("holder_name")
    private String holderName;
    @SerializedName("holder_tax_id")
    private String holderTaxId;
    @SerializedName("bank_code")
    private String bankCode;
    @SerializedName("bank_name")
    private String bankName;
    @SerializedName("bank_branch")
    private String bankBranch;
    @SerializedName("bank_account")
    private String bankAccount;

    /**
     * Constructors
     */
    public KondutoBank() {
    }

    @Override
    public KondutoBank with(String attributeName, Object attributeValue) {
        return (KondutoBank) super.with(attributeName, attributeValue);
    }

    /**
     * Equals and hashCode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KondutoBank)) return false;

        KondutoBank that = (KondutoBank) o;

        if (id != that.id) return false;
        if (keyType != null ? !keyType.equals(that.keyType) : that.keyType != null) return false;
        if (keyValue != null ? !keyValue.equals(that.keyValue) : that.keyValue != null) return false;
        if (holderName != null ? !holderName.equals(that.holderName) : that.holderName != null) return false;
        if (holderTaxId != null ? !holderTaxId.equals(that.holderTaxId) : that.holderTaxId != null) return false;
        if (bankCode != null ? !bankCode.equals(that.bankCode) : that.bankCode != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (bankBranch != null ? !bankBranch.equals(that.bankBranch) : that.bankBranch != null) return false;
        if (bankAccount != null ? !bankAccount.equals(that.bankAccount) : that.bankAccount != null) return false;

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getKeyType(), getKeyValue(), getHolderName(),
                getHolderTaxId(), getBankCode(), getBankName(), getBankBranch(),
                getBankAccount());
    }

    /**
     * Getters/setters
     */

    /**
     * Gets the bank account unique identifier.
     *
     * @return the bank account ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the bank account unique identifier.
     *
     * @param id the bank account ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the type of document used as key for this bank account.
     *
     * @return the key type
     */
    public KondutoBankDocumentType getKeyType() {
        return keyType;
    }

    /**
     * Sets the type of document used as key for this bank account.
     *
     * @param keyType the key type
     */
    public void setKeyType(KondutoBankDocumentType keyType) {
        this.keyType = keyType;
    }

    /**
     * Gets the value of the document used as key for this bank account.
     *
     * @return the key value
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * Sets the value of the document used as key for this bank account.
     *
     * @param keyValue the key value
     */
    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    /**
     * Gets the account holder's name.
     *
     * @return the holder name
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * Sets the account holder's name.
     *
     * @param holderName the holder name
     */
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * Gets the account holder's tax ID.
     *
     * @return the holder tax ID
     */
    public String getHolderTaxId() {
        return holderTaxId;
    }

    /**
     * Sets the account holder's tax ID.
     *
     * @param holderTaxId the holder tax ID
     */
    public void setHolderTaxId(String holderTaxId) {
        this.holderTaxId = holderTaxId;
    }

    /**
     * Gets the bank code.
     *
     * @return the bank code
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * Sets the bank code.
     *
     * @param bankCode the bank code
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * Gets the bank name.
     *
     * @return the bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the bank name.
     *
     * @param bankName the bank name
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Gets the bank branch code.
     *
     * @return the bank branch
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * Sets the bank branch code.
     *
     * @param bankBranch the bank branch
     */
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    /**
     * Gets the bank account number.
     *
     * @return the bank account
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the bank account number.
     *
     * @param bankAccount the bank account
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "KondutoBank{" +
                "id='" + id + '\'' +
                ", keyType=" + keyType +
                ", keyValue='" + keyValue + '\'' +
                ", holderName='" + holderName + '\'' +
                ", holderTaxId='" + holderTaxId + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}
