package com.konduto.sdk.exceptions;

/**
 * Created by rsampaio on 05/08/14.
 */
public class KondutoUnexpectedAPIResponseException extends KondutoException {

	private String responseBody;

	public KondutoUnexpectedAPIResponseException(String responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String getMessage() {
		return String.format("Unexpected API response: %s", this.responseBody);
	}
}
