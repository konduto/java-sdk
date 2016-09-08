package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Credit card status enum.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoPaymentStatus {
	@SerializedName("approved")
	APPROVED,
	@SerializedName("declined")
	DECLINED,
	@SerializedName("pending")
	PENDING;
}
