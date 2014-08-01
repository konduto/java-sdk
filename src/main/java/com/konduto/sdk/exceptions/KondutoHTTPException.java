package com.konduto.sdk.exceptions;

import org.json.JSONObject;

/**
 * Created by rsampaio on 01/08/14.
 */
public abstract class KondutoHTTPException extends KondutoException {
	private String message;

	protected KondutoHTTPException(String message, JSONObject responseBody){
		this.message = String.format("%s - Response body: %s", message, responseBody);
	}

	@Override
	public String getMessage() { return this.message; }
}
