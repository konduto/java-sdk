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

	public abstract String getMessage();

}