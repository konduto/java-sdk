package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoCustomerFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
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
	public void serializationTest() throws ParseException {
		KondutoCustomer customer = KondutoCustomerFactory.completeCustomer();
		JsonObject customerJSON = (JsonObject) TestUtils.readJSONFromFile("customer.json");
		try {
			assertEquals("serialization failed", customerJSON, customer.toJSON());
		} catch (KondutoInvalidEntityException e) {
			e.printStackTrace();
		}

		KondutoCustomer deserializedCustomer = (KondutoCustomer)
				KondutoModel.fromJSON(customerJSON, KondutoCustomer.class);

		assertEquals("deserialization failed", customer, deserializedCustomer);

	}

	@Test(expected=KondutoInvalidEntityException.class)
	public void invalidCustomerSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
		KondutoCustomer customer = new KondutoCustomer();
		customer.toJSON(); // triggers invalid customer exception
	}
}
