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
