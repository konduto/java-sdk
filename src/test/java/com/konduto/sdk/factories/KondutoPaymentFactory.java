package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoCreditCardPayment;
import com.konduto.sdk.models.KondutoCreditCardPaymentStatus;
import com.konduto.sdk.models.KondutoPayment;

import java.util.Collection;
import java.util.HashSet;

/**
 */
public class KondutoPaymentFactory {
	public static KondutoCreditCardPayment getCreditCardPayment(){
		KondutoCreditCardPayment creditCardPayment = new KondutoCreditCardPayment();
		creditCardPayment.setBin("123");
		creditCardPayment.setExpirationDate("012014");
		creditCardPayment.setLast4("1234");
		creditCardPayment.setStatus(KondutoCreditCardPaymentStatus.APPROVED);
		return creditCardPayment;
	}

	public static Collection<KondutoPayment> getPayments() {
		Collection<KondutoPayment> payments = new HashSet<>();
		payments.add(getCreditCardPayment());
		return payments;
	}
}
