package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
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
	KondutoPaymentStatus status;

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

	public KondutoPaymentStatus getStatus() {
		return status;
	}

	public void setStatus(KondutoPaymentStatus status) {
		this.status = status;
	}

	abstract public KondutoPaymentType getType();

	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof KondutoPayment)) return false;
        KondutoPayment that = (KondutoPayment) obj;
        if(this.getType() != that.getType()) { return false; }
        return this.status.equals(that.status);
    }

	@Override
	public int hashCode() {
        int result = this.getType().hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
