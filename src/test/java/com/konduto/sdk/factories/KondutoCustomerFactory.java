package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoCustomer;

/**
 */
public class KondutoCustomerFactory {

	public static KondutoCustomer basicCustomer(){
		KondutoCustomer customer = new KondutoCustomer();
		customer.setId("1");
		customer.setName("José da Silva");
		customer.setEmail("jose.silva@gmail.com");
		return customer;
	}

	public static KondutoCustomer completeCustomer() {
		KondutoCustomer customer = basicCustomer();
		customer.setIsNew(false);
		customer.setIsVip(false);
		customer.setPhone1("11987654321");
		customer.setPhone2("1133333333");
		customer.setTaxId("01234567890");
		return customer;
	}

}
