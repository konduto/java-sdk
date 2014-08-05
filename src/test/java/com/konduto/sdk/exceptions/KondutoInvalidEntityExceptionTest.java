package com.konduto.sdk.exceptions;

import com.konduto.sdk.models.KondutoCustomer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoInvalidEntityExceptionTest {

	@Test
	public void invalidEntityExceptionMessageTest() {
		KondutoCustomer customer = new KondutoCustomer();
		customer.isValid(); // triggers errors
		KondutoInvalidEntityException exception = new KondutoInvalidEntityException(customer);

		assertEquals("incorrect expected exception message",
				String.format("%s is invalid: %s", customer, customer.getErrors()), exception.getMessage());
	}
}
