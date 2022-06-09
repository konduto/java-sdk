package com.konduto.sdk.models;

/**
 * Bank Origin Account  model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoBankOriginAccount extends KondutoBank {

    private Double balance;

    /** Constructors */
    public KondutoBankOriginAccount(){}

    /**
     * Fluent constructor implementation
     *
     * @param attributeName  the attribute name (e.g greeting)
     * @param attributeValue the attribute value (e.g "Hello")
     * @return a new instance
     * @see <a href=http://en.wikipedia.org/wiki/Fluent_interface>Fluent interface article</a>
     */
    @Override
    public KondutoBankOriginAccount with(String attributeName, Object attributeValue) {
        return (KondutoBankOriginAccount) super.with(attributeName, attributeValue);
    }

    /** Equals and hashCode */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoBankOriginAccount that = (KondutoBankOriginAccount) o;

        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;

    }

    /** Getters/setters */

    public Double getBalance() {return balance;}
    public void setBalance(Double balance) {this.balance = balance;}

}
