package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Order sales channel enum, used bu KondutoOption.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoSalesChannel {
	@SerializedName("ivr")
	IVR,
	@SerializedName("moto")
	MOTO,
	@SerializedName("web")
	WEB,
	@SerializedName("app")
	APP
}
