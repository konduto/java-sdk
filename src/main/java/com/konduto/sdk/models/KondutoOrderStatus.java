package com.konduto.sdk.models;

/**
 * Created by rsampaio on 01/08/14.
 */
public enum KondutoOrderStatus {
	PENDING("pending"),
	APPROVED("approved"),
	DECLINED("declined"),
	FRAUD("fraud"),
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
