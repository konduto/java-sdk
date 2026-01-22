package com.konduto.sdk.exceptions;

/**
 *
 * This exception is the parent of all Konduto exceptions.
 *
 * Use it to catch any instance of its children and handle as you wish
 * (e.g saving an order, reporting to our support team automatically, etc.)
 *
 */
public class KondutoException extends Exception {

    private static final long serialVersionUID = 1920403867720844824L;

    /**
     * Default constructor.
     */
    public KondutoException() {
        super();
    }

    /**
     * Constructor with message.
     * @param message the exception message
     */
    public KondutoException(String message) {
        super(message);
    }
}