package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Bank Origin Account  model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoOriginAccount extends KondutoModel {

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
    private Double balance;

    /** Constructors */
    public KondutoOriginAccount(){}

    /**
     * Fluent constructor implementation
     *
     * @param attributeName  the attribute name (e.g greeting)
     * @param attributeValue the attribute value (e.g "Hello")
     * @return a new instance
     * @see <a href=http://en.wikipedia.org/wiki/Fluent_interface>Fluent interface article</a>
     */
    @Override
    public KondutoOriginAccount with(String attributeName, Object attributeValue) {
        return (KondutoOriginAccount) super.with(attributeName, attributeValue);
    }

    /** Equals and hashCode */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoOriginAccount that = (KondutoOriginAccount) o;

        if (id != that.id) return false;
        if (keyType != null ? !keyType.equals(that.keyType) : that.keyType != null) return false;
        if (keyValue != null ? !keyValue.equals(that.keyValue) : that.keyValue != null) return false;
        if (holderName != null ? !holderName.equals(that.holderName) : that.holderName != null) return false;
        if (holderTaxId != null ? !holderTaxId.equals(that.holderTaxId) : that.holderTaxId != null) return false;
        if (bankCode != null ? !bankCode.equals(that.bankCode) : that.bankCode != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (bankBranch != null ? !bankBranch.equals(that.bankBranch) : that.bankBranch != null) return false;
        if (bankAccount != null ? !bankAccount.equals(that.bankAccount) : that.bankAccount != null) return false;

        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), keyType, getKeyValue(), getHolderName(), getHolderTaxId(), getBankCode(), getBankName(), getBankBranch(), getBankAccount(), getBalance());
    }

    /** Getters/setters */

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public KondutoBankDocumentType getKeyType() {
        return keyType;
    }
    public void setKeyType(KondutoBankDocumentType keyType) {
        this.keyType = keyType;
    }

    public String getKeyValue() {
        return keyValue;
    }
    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderTaxId() {
        return holderTaxId;
    }
    public void setHolderTaxId(String holderTaxId) {
        this.holderTaxId = holderTaxId;
    }

    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Double getBalance() {return balance;}
    public void setBalance(Double balance) {this.balance = balance;}

    @Override
    public String toString() {
        return "KondutoOriginAccount{" +
                "id='" + id + '\'' +
                ", keyType=" + keyType +
                ", keyValue='" + keyValue + '\'' +
                ", holderName='" + holderName + '\'' +
                ", holderTaxId='" + holderTaxId + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", balance=" + balance +
                '}';
    }
}
