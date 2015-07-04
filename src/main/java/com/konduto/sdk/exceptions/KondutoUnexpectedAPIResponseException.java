package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;

/**
 *
 * This exception is thrown whenever Konduto's API responds something we cannot handle.
 * Please contact our support team if this ever happens.
 */
public class KondutoUnexpectedAPIResponseException extends KondutoException {

	private static final long serialVersionUID = 7090880437649169406L;
	private JsonObject responseBody;

	public KondutoUnexpectedAPIResponseException(JsonObject responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String getMessage() {
		return String.format("Unexpected API response: %s", this.responseBody);
	}
}
