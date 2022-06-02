package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoPointOfSale;

/**
 * {
 *         "point_of_sale":{
 *         "id":000500,
 *     "name":"Capital Representações",
 *     "lat":-23.5677666,
 *     "long":-46.6487763,
 *     "address":"Rua Dez de Abril, 23",
 *     "city":"São Paulo",
 *     "state":"SP",
 *     "zip":"01001-001",
 *     "country":"BR"
 *   }
 * }
 */
public class KondutoPointOfSaleFactory {
	public static KondutoPointOfSale getPointOfSale() {
		KondutoPointOfSale pointOfSale = new KondutoPointOfSale();
		pointOfSale.setId("000500");
		pointOfSale.setName("Capital Representações");
		pointOfSale.setLat(-23.5677666);
		pointOfSale.setLon(-46.6487763);
		pointOfSale.setAddress("Rua Dez de Abril, 23");
		pointOfSale.setCity("São Paulo");
		pointOfSale.setState("SP");
		pointOfSale.setZip("01001-001");
		pointOfSale.setCountry("BR");
		return pointOfSale;
	}
}
