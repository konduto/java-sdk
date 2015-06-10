package com.konduto.sdk.factories;

import com.konduto.sdk.models.*;

import java.text.ParseException;
import java.util.Date;

/**
 */
public class KondutoOrderFactory {

	public static KondutoOrder completeOrder() throws ParseException {
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
		KondutoTravel travel = new KondutoTravel();
		travel.setDepartureLeg(KondutoTravelLegFactory.departureFlight());
		travel.setReturnLeg(KondutoTravelLegFactory.returnFlight());
        travel.setPassengers(KondutoPassengerFactory.passengersList());
        travel.setTravelType(KondutoTravelType.FLIGHT);
		order.setTravel(travel);
		order.setFirst_message(new Date(1433874421000L));
		order.setPurchased_at(new Date(1433874421000L));
		order.setMessages_exchanged(2);
		order.setSeller(KondutoSellerFactory.getKondutoSeller());

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
