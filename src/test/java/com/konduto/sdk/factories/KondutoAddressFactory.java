package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoAddress;
import com.konduto.sdk.models.KondutoGeolocation;

/**
 * Created by rsampaio on 06/08/14.
 */
public class KondutoAddressFactory {
	public static KondutoAddress addressWithoutGeolocation() {
		KondutoAddress address = new KondutoAddress();
		address.setAddress1("R. Teodoro Sampaio, 2393");
		address.setAddress2("CJ. 111");
		address.setZip("05406-200");
		return address;
	}

	public static KondutoAddress addressWithGeolocation() {
		KondutoAddress address = addressWithoutGeolocation();
		address.setCity("São Paulo");
		address.setState("SP");
		address.setCountry("BR");
		return address;
	}

	public static KondutoGeolocation getGeolocation() {
		KondutoGeolocation geolocation = new KondutoGeolocation();
		geolocation.setCity("São Paulo");
		geolocation.setState("SP");
		geolocation.setCountry("BR");
		return geolocation;
	}

}
