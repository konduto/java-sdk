package com.konduto.sdk.factories;

import com.konduto.sdk.models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 */
public class KondutoPaymentFactory {
	public static KondutoCreditCardPayment getCreditCardPayment() {
		KondutoCreditCardPayment creditCardPayment = new KondutoCreditCardPayment();
		creditCardPayment.setBin("123");
		creditCardPayment.setExpirationDate("012014");
		creditCardPayment.setLast4("1234");
		creditCardPayment.setStatus(KondutoPaymentStatus.APPROVED);
		return creditCardPayment;
	}

	public static KondutoBoletoPayment getBoletoPayment() throws ParseException {
		KondutoBoletoPayment boletoPayment = new KondutoBoletoPayment();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		boletoPayment.setExpirationDate(sdf.parse("2016-10-01"));
		boletoPayment.setStatus(KondutoPaymentStatus.PENDING);
		return boletoPayment;
	}

	public static KondutoDebitPayment getDebitPayment() {
		return new KondutoDebitPayment();
	}

	public static KondutoTransferPayment getTransferPayment() {
		return new KondutoTransferPayment();
	}

	public static KondutoVoucherPayment getVoucherPayment() {
		return new KondutoVoucherPayment();
	}

	public static Collection<KondutoPayment> getPayments() {
		Collection<KondutoPayment> payments = new ArrayList<KondutoPayment>();
		payments.add(getCreditCardPayment());
		return payments;
	}
}
