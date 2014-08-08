package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;

/**
 * Created by rsampaio on 01/08/14.
 */
public abstract class KondutoHTTPException extends KondutoException {
	private String message;

	protected KondutoHTTPException(String message, JsonObject responseBody){
		this.message = String.format("%s - Response body: %s", message, responseBody.toString());
	}

	@Override
	public String getMessage() { return this.message; }
}
