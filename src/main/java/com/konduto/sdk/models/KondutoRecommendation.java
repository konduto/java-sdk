package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Recommendation enum.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
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
