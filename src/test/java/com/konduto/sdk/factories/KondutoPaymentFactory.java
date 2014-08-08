package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoCreditCardPayment;
import com.konduto.sdk.models.KondutoCreditCardPaymentStatus;
import com.konduto.sdk.models.KondutoPayment;

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

	public static KondutoPayment[] getPaymentArray() {
		return new KondutoPayment[]{ getCreditCardPayment() };
	}
}
