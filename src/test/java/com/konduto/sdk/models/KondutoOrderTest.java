package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoCustomerFactory;
import com.konduto.sdk.factories.KondutoOrderFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
*/
public class KondutoOrderTest {

	@Test
	public void isValidTest(){
		KondutoOrder order = new KondutoOrder();

		assertFalse("order should be invalid without id", order.isValid());

		order.setId("order1");

		assertFalse("order should be invalid without total amount", order.isValid());

		order.setTotalAmount(120.1);

		assertFalse("order should be invalid without customer", order.isValid());

		order.setCustomer(KondutoCustomerFactory.basicCustomer());

		assertTrue("order should be valid", order.isValid());

		assertTrue("order errors should be empty", order.errors.isEmpty());
	}

	@Test
	public void serializationTest() throws Exception {
		KondutoOrder order = KondutoOrderFactory.completeOrder();
		JsonObject orderJSON = (JsonObject) TestUtils.readJSONFromFile(
				"order.json");
		try {
			assertEquals("serialization failed", orderJSON, order.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("order should be valid");
		}

		KondutoOrder deserializedOrder = (KondutoOrder) KondutoModel.fromJSON(orderJSON, KondutoOrder.class);
		// assertEquals("deserialization failed", order, deserializedOrder);

		assertEquals("Id deve ser igual", order.getId(), deserializedOrder.getId());
		assertEquals("TotalAmount deve ser igual", order.getTotalAmount(), deserializedOrder.getTotalAmount());
		assertEquals("Customer Basic Id deve ser igual", order.getCustomer().getId(), deserializedOrder.getCustomer().getId());
		assertEquals("Customer Basic Name deve ser igual", order.getCustomer().getName(), deserializedOrder.getCustomer().getName());
		assertEquals("Customer Basic Email deve ser igual", order.getCustomer().getEmail(), deserializedOrder.getCustomer().getEmail());
		
	}

	@Test(expected=KondutoInvalidEntityException.class)
	public void invalidOrderSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
		KondutoOrder order = new KondutoOrder();
		order.toJSON(); // triggers invalid customer exception
	}
}
