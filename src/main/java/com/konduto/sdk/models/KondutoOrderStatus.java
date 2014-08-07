package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rsampaio on 01/08/14.
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
	@SerializedName("not_analyzed")
	NOT_ANALYZED;

}
