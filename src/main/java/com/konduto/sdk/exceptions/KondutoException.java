package com.konduto.sdk.exceptions;

/**
 *
 * This exception is the parent of all Konduto exceptions.
 *
 * Use it to catch any instance of its children and handle as you wish
 * (e.g saving an order, reporting to our support team automatically, etc.)
 *
 */
public abstract class KondutoException extends Exception {

	private static final long serialVersionUID = 1920403867720844824L;

	public abstract String getMessage();

}