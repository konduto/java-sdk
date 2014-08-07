package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rsampaio on 01/08/14.
 */
public enum KondutoRecommendation {
	@SerializedName("approve")
	APPROVE,
	@SerializedName("review")
	REVIEW,
	@SerializedName("decline")
	DECLINE,
	@SerializedName("none")
	NONE;
}
