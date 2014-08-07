package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rsampaio on 06/08/14.
 */
public enum KondutoPaymentStatus {
	@SerializedName("approved")
	APPROVED("approved"),
	@SerializedName("declined")
	DECLINED("declined");

	private String text;


	KondutoPaymentStatus(String text) {
		this.text = text;
	}

	public String getText(){
		return this.text;
	}

	public static KondutoPaymentStatus fromString(String text) {
		if (text != null) {
			for (KondutoPaymentStatus paymentStatus : KondutoPaymentStatus.values()) {
				if (text.equalsIgnoreCase(paymentStatus.text)) {
					return paymentStatus;
				}
			}
		}
		return null;
	}
}
