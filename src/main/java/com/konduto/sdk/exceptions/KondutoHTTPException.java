package com.konduto.sdk.exceptions;

import com.google.gson.JsonObject;

/**
 *
 * This exception will be thrown whenever Konduto's API responds with an error HTTP status.
 *
 * @see com.konduto.sdk.Konduto#sendRequest
 */
public abstract class KondutoHTTPException extends KondutoException {

	private static final long serialVersionUID = -1046719551304454324L;
	private String message;

	/**
	 *
	 * @param message instance's message
	 * @param responseBody Konduto's API response
	 */
	protected KondutoHTTPException(String message, JsonObject responseBody){
		this.message = String.format("%s Response body: %s", message, responseBody.toString());
	}

	@Override
	public String getMessage() { return this.message; }
}
