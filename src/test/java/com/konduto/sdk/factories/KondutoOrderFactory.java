package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoOrder;
import com.konduto.sdk.models.KondutoOrderStatus;
import com.konduto.sdk.models.KondutoRecommendation;

/**
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
		order.setShippingAddress(KondutoAddressFactory.getAddress());
		order.setBillingAddress(KondutoAddressFactory.getAddress());
		order.setGeolocation(KondutoGeolocationFactory.getGeolocation());
		order.setStatus(KondutoOrderStatus.APPROVED);
		order.setRecommendation(KondutoRecommendation.APPROVE);
		order.setPayments(KondutoPaymentFactory.getPayments());
		order.setShoppingCart(KondutoItemFactory.getShoppingCart());
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
