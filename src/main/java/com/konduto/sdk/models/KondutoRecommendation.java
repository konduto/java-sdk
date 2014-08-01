package com.konduto.sdk.models;

/**
 * Created by rsampaio on 01/08/14.
 */
public enum KondutoRecommendation {
	APPROVE("approve"),
	REVIEW("review"),
	DECLINE("decline"),
	NONE("none");

	private String text;

	KondutoRecommendation(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static KondutoRecommendation fromString(String text) {
		if (text != null) {
			for (KondutoRecommendation recommendation : KondutoRecommendation.values()) {
				if (text.equalsIgnoreCase(recommendation.text)) {
					return recommendation;
				}
			}
		}
		return null;
	}
}
