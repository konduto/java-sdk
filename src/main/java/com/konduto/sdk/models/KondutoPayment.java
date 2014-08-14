package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 *
 * Payment model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public abstract class KondutoPayment extends KondutoModel {

	public KondutoPayment(KondutoPaymentType type){ this.type = type; }

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

	@Required
	public KondutoPaymentType type;

	public KondutoPaymentType getType(){
		return this.type;
	}

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract int hashCode();
}
