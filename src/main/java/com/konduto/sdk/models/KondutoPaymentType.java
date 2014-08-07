package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rsampaio on 06/08/14.
 */
public enum KondutoPaymentType {
	@SerializedName("credit")
	CREDIT("credit");
	private String text;


	KondutoPaymentType(String text) {
		this.text = text;
	}

	public String getText(){
		return this.text;
	}

	public static KondutoPaymentType fromString(String text) {
		if (text != null) {
			for (KondutoPaymentType paymentType : KondutoPaymentType.values()) {
				if (text.equalsIgnoreCase(paymentType.text)) {
					return paymentType;
				}
			}
		}
		return null;
	}
}
