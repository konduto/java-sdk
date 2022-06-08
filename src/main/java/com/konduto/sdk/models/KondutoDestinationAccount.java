package com.konduto.sdk.models;

/**
 * KondutoSafeBank model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoDestinationAccount extends KondutoBank {

    private Double amount;

    /** Constructors */
    public KondutoDestinationAccount(){}

    /**
     * Fluent constructor implementation
     *
     * @param attributeName  the attribute name (e.g greeting)
     * @param attributeValue the attribute value (e.g "Hello")
     * @return a new instance
     * @see <a href=http://en.wikipedia.org/wiki/Fluent_interface>Fluent interface article</a>
     */
    @Override
    public KondutoDestinationAccount with(String attributeName, Object attributeValue) {
        return (KondutoDestinationAccount) super.with(attributeName, attributeValue);
    }

    /** Equals and hashCode */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoDestinationAccount that = (KondutoDestinationAccount) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;

    }

    /** Getters/setters */

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
