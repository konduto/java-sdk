package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;

/**
 * Created by rsampaio on 05/08/14.
 */
public class KondutoUnexpectedAPIResponseException extends KondutoException {

	private JsonObject responseBody;

	public KondutoUnexpectedAPIResponseException(JsonObject responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String getMessage() {
		return String.format("Unexpected API response: %s", this.responseBody);
	}
}
