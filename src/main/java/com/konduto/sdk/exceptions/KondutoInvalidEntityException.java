package com.konduto.sdk.exceptions;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoInvalidEntityException extends Exception {
	private String entity;

	public KondutoInvalidEntityException(String entity) {
		this.entity = entity;
	}

	@Override
	public String getMessage() {
		return String.format("%s is invalid", this.entity);
	}
}
