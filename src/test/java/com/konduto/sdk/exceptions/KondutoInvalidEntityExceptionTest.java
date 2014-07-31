package com.konduto.sdk.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoInvalidEntityExceptionTest {

	@Test
	public void invalidEntityExceptionMessageTest() {
		KondutoInvalidEntityException exception = new KondutoInvalidEntityException("customer");
		assertEquals("message should be 'customer is invalid'", "customer is invalid", exception.getMessage());
	}
}
