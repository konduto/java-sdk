package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
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
		KondutoOrder actualOrder = null;
		try {
			actualOrder = new KondutoOrder(expectedOrder.toJSON());
		} catch (KondutoInvalidEntityException e) {
			e.printStackTrace();
		}
		assertEquals("actual order should equal the expected order", expectedOrder, actualOrder);
	}

	@Test
	public void serializationWithOptFieldsTest() {
		KondutoOrder expectedOrder = KondutoOrderFactory.basicOrder();
		KondutoOrder actualOrder = null;
		try {
			actualOrder = new KondutoOrder(expectedOrder.toJSON());
		} catch (KondutoInvalidEntityException e) {
			e.printStackTrace();
		}
		assertEquals("actual order should equal the expected order", expectedOrder, actualOrder);
	}

	@Test(expected=KondutoInvalidEntityException.class)
	public void invalidOrderSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
		KondutoOrder order = new KondutoOrder();
		order.toJSON(); // triggers invalid customer exception
	}
}
