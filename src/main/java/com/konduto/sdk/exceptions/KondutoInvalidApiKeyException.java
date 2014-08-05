package com.konduto.sdk.exceptions;

/**
 * Created by rsampaio on 05/08/14.
 */
public class KondutoInvalidApiKeyException extends KondutoException {
	private String apiKey;

	public KondutoInvalidApiKeyException(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String getMessage() {
		return String.format("%s is an invalid API Key", this.apiKey);
	}
}
