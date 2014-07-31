package com.konduto.sdk.models;

import com.konduto.sdk.factories.KondutoCustomerFactory;
import com.konduto.sdk.factories.KondutoOrderFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rsampaio on 31/07/14.
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
	public void serializationTest() {
		KondutoOrder expectedOrder = KondutoOrderFactory.completeOrder();
		KondutoOrder actualOrder = KondutoOrder.fromJSON(expectedOrder.toJSON());
		assertEquals("actual order should equal the expected order", expectedOrder, actualOrder);
	}

	@Test
	public void serializationWithOptFieldsTest() {
		KondutoOrder expectedOrder = KondutoOrderFactory.basicOrder();
		KondutoOrder actualOrder = KondutoOrder.fromJSON(expectedOrder.toJSON());
		assertEquals("actual order should equal the expected order", expectedOrder, actualOrder);
	}
}
