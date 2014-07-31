package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoCustomerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoCustomerTest {

	@Test
	public void isValidTest() {
		KondutoCustomer customer = new KondutoCustomer();
		assertFalse("customer should be invalid without id", customer.isValid());
		customer.setId("customer1");
		assertFalse("customer should be invalid without name", customer.isValid());
		customer.setName("José da Silva");
		assertFalse("customer should be invalid without email", customer.isValid());
		customer.setEmail("jose.silva@gmail.com");
		assertTrue("customer should be valid", customer.isValid());
	}

	@Test
	public void serializationTest() {
		KondutoCustomer expectedCustomer = KondutoCustomerFactory.completeCustomer();
		KondutoCustomer actualCustomer = null;
		try {
			actualCustomer = KondutoCustomer.fromJSON(expectedCustomer.toJSON());
		} catch (KondutoInvalidEntityException e) {
			e.printStackTrace();
		}
		assertEquals("actual customer should equal the expected customer", expectedCustomer, actualCustomer);
	}

	@Test
	public void serializationWithOptFieldsTest() {
		KondutoCustomer expectedCustomer = KondutoCustomerFactory.basicCustomer();
		KondutoCustomer actualCustomer = null;
		try {
			actualCustomer = KondutoCustomer.fromJSON(expectedCustomer.toJSON());
		} catch (KondutoInvalidEntityException e) {
			e.printStackTrace();
		}
		assertEquals("actual customer should equal the expected customer", expectedCustomer, actualCustomer);
	}

	@Test(expected=KondutoInvalidEntityException.class)
	public void invalidCustomerThrowsExceptionTest() throws KondutoInvalidEntityException {
		KondutoCustomer customer = new KondutoCustomer();
		customer.toJSON(); // triggers invalid customer exceptions
	}
}
