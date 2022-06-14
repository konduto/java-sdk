package com.konduto.sdk.models;

import java.util.Objects;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 08/06/2022.
 * Konduto Bank destination accounts model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoBankDestinationAccount extends KondutoBank {

    private Double amount;

    /** Constructors */
    public KondutoBankDestinationAccount(){}

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

    /** Equals and hashCode */
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

    /** Getters/setters */

    public Double getAmount() {
        return amount;
    }

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
