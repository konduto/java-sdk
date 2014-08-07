package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoGeolocation;

/**
 * Created by rsampaio on 07/08/14.
 */
public class KondutoGeolocationFactory {

	public static KondutoGeolocation getGeolocation(){
		KondutoGeolocation geolocation = new KondutoGeolocation();
		geolocation.setCity("São Paulo");
		geolocation.setState("SP");
		geolocation.setCountry("BR");
		return geolocation;
	}
}
