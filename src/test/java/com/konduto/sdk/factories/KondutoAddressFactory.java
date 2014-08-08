package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoAddress;

/**
 */
public class KondutoAddressFactory {
	public static KondutoAddress getAddress() {
		KondutoAddress address = new KondutoAddress();
		address.setName("Konduto");
		address.setAddress1("R. Teodoro Sampaio, 2393");
		address.setAddress2("CJ. 111");
		address.setZip("05406-200");
		address.setCity("São Paulo");
		address.setState("SP");
		address.setCountry("BR");
		return address;
	}
}
