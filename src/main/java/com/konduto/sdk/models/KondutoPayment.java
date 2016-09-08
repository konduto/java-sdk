package com.konduto.sdk.models;

/**
 *
 * Payment model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public abstract class KondutoPayment extends KondutoModel {

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoPayment with(String attributeName, Object attributeValue) {
		return (KondutoPayment) super.with(attributeName, attributeValue);
	}

	abstract public KondutoPaymentType getType();

	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof KondutoPayment)) return false;
        KondutoPayment that = (KondutoPayment) obj;
        return this.getType() == that.getType();
    }

	@Override
	public int hashCode() {
        return this.getType().hashCode();
    }

	public String getTypeAsString() {
        if(getType() == null) { throw new RuntimeException("Payment type cannot be null"); }
        return getType().toString().toLowerCase();
    }
}
