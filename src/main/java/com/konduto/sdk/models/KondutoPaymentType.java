package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Payment type enum.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoPaymentType {
	@SerializedName("credit")
	CREDIT;
}
