package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Represents a bank destination account in the Konduto system.
 * This class extends KondutoBank and contains destination account specific attributes.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoBankDestinationAccount extends KondutoBank {
    @SerializedName(value = "amount")
    private Double amount;

    /**
     * Constructors
     */
    public KondutoBankDestinationAccount() {
    }

    /**
     * Fluent constructor implementation
     *
     * @param attributeName  the attribute name (e.g greeting)
     * @param attributeValue the attribute value (e.g "Hello")
     * @return a new instance
     * @see <a href=http://en.wikipedia.org/wiki/Fluent_interface>Fluent interface article</a>
     */
    @Override
    public KondutoBankDestinationAccount with(String attributeName, Object attributeValue) {
        return (KondutoBankDestinationAccount) super.with(attributeName, attributeValue);
    }

    /**
     * Equals and hashCode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoBankDestinationAccount that = (KondutoBankDestinationAccount) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAmount());
    }

    /**
     * Getters/setters
     */

    /**
     * Gets the transfer amount for this destination account.
     *
     * @return the transfer amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the transfer amount for this destination account.
     *
     * @param amount the transfer amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "KondutoBankDestinationAccount{" +
                "amount=" + amount +
                '}';
    }
}
