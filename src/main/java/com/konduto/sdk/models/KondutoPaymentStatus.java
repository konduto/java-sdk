package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rsampaio on 06/08/14.
 */
public enum KondutoPaymentStatus {
	@SerializedName("approved")
	APPROVED,
	@SerializedName("declined")
	DECLINED;
}
