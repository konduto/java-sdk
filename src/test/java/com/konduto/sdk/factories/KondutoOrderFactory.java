package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoOrder;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoOrderFactory {

	public static KondutoOrder completeOrder(){
		KondutoOrder order = basicOrder();
		order.setVisitor("a9031kdlas");
		order.setCurrency("USD");
		order.setInstallments(1);
		order.setIp("192.168.0.1");
		order.setShippingAmount(5.0);
		order.setTaxAmount(3.0);
		order.setTimestamp(123123123123L);
		order.setCustomer(KondutoCustomerFactory.completeCustomer());
		return order;
	}

	public static KondutoOrder basicOrder(){
		KondutoOrder order = new KondutoOrder();
		order.setId("1");
		order.setTotalAmount(120.5);
		order.setCustomer(KondutoCustomerFactory.basicCustomer());
		return order;
	}

}
