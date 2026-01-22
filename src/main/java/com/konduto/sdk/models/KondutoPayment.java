package com.konduto.sdk.models;

/**
 * Abstract base class for all payment types in the Konduto system.
 * This class extends KondutoModel and provides common payment attributes such as description and amount.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public abstract class KondutoPayment extends KondutoModel {

	private String description;
	private Double amount;

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

	/**
	 * Gets the payment type for this payment method.
	 *
	 * @return the payment type
	 */
	abstract public KondutoPaymentType getType();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		KondutoPayment that = (KondutoPayment) o;
		return this.getType() == that.getType() &&
				equals(this.getDescription(), that.getDescription()) &&
				equals(this.getAmount(), that.getAmount());
 	}

	@Override
	public int hashCode() {
        return this.getType().hashCode();
    }

	public String getTypeAsString() {
        if(getType() == null) { throw new RuntimeException("Payment type cannot be null"); }
        return getType().toString().toLowerCase();
    }

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
