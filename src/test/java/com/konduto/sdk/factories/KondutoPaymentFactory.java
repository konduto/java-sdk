package com.konduto.sdk.factories;

import com.konduto.sdk.models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 */
public class KondutoPaymentFactory {
	public static KondutoCreditCardPayment getCreditCardPayment() {
		KondutoCreditCardPayment creditCardPayment = new KondutoCreditCardPayment();
		creditCardPayment.setBin("406655");
		creditCardPayment.setExpirationDate("012017");
		creditCardPayment.setLast4("1234");
		creditCardPayment.setStatus(KondutoPaymentStatus.APPROVED);
		creditCardPayment.setDescription("pagamento via cartão de crédito");
		creditCardPayment.setAmount(12.39);
		return creditCardPayment;
	}

	public static KondutoBoletoPayment getBoletoPayment() {
		KondutoBoletoPayment boletoPayment = new KondutoBoletoPayment();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			boletoPayment.setExpirationDate(sdf.parse("2016-10-12"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
        payments.add(getBoletoPayment());
        payments.add(getDebitPayment());
        payments.add(getTransferPayment());
        payments.add(getVoucherPayment());
		return payments;
	}
}
