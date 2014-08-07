package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rsampaio on 01/08/14.
 */
public enum KondutoOrderStatus {
	@SerializedName("pending")
	PENDING("pending"),
	@SerializedName("approved")
	APPROVED("approved"),
	@SerializedName("declined")
	DECLINED("declined"),
	@SerializedName("fraud")
	FRAUD("fraud"),
	@SerializedName("not analyzed")
	NOT_ANALYZED("not analyzed");

	private String text;

	KondutoOrderStatus(String text) {
		this.text = text;
	}

	public String getText(){
		return this.text;
	}

	public static KondutoOrderStatus fromString(String text) {
		if (text != null) {
			for (KondutoOrderStatus orderStatus : KondutoOrderStatus.values()) {
				if (text.equalsIgnoreCase(orderStatus.text)) {
					return orderStatus;
				}
			}
		}
		return null;
	}

}
