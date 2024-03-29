package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoOrder;
import com.konduto.sdk.models.KondutoOrderStatus;
import com.konduto.sdk.models.KondutoRecommendation;
import com.konduto.sdk.models.KondutoTravel;
import com.konduto.sdk.models.KondutoTravelType;

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
		order.setFirstMessage(new Date(1433874421000L));
		order.setPurchasedAt(new Date(1433874421000L));
		order.setMessagesExchanged(2);
		order.setSeller(KondutoSellerFactory.getKondutoSeller());
		order.setBureauxQueries(KondutoBureauQueryFactory.getQueries());
		order.setEvents(KondutoEventFactory.getMultipleEvents());
		order.setVehicle(KondutoVehicleFactory.getVehicle());
		order.setDelivery(KondutoDeliveryFactory.getDelivery());
		order.setPointOfSale(KondutoPointOfSaleFactory.getPointOfSale());
		order.setAgent(KondutoAgentSellerFactory.getAgentSeller());
		order.setOriginAccount(KondutoBankOriginAccountFactory.getOriginAccount());
		order.setDestinationAccounts(KondutoBankDestinationAccountFactory.getDestinationAccounts());
		order.setTenant(KondutoTenantFactory.getKondutoTenant());
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
