package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Order status enum.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoOrderStatus {
	@SerializedName("pending")
	PENDING,
	@SerializedName("approved")
	APPROVED,
	@SerializedName("declined")
	DECLINED,
	@SerializedName("fraud")
	FRAUD,
	@SerializedName("not_authorized")
	NOT_AUTHORIZED,
	@SerializedName("not_analyzed")
	NOT_ANALYZED,
	@SerializedName("canceled")
	CANCELED
}
