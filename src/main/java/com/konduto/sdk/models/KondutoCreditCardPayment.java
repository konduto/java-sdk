package com.konduto.sdk.models;

/**
 * Created by rsampaio on 07/08/14.
 */
public class KondutoCreditCardPayment extends KondutoPayment {

	private String bin;
	private String last4;
	private String expirationDate;
	private KondutoCreditCardPaymentStatus status;

	public KondutoCreditCardPayment(){
		this.type = KondutoPaymentType.CREDIT;
	}

	public KondutoCreditCardPaymentStatus getStatus() {
		return status;
	}

	public void setStatus(KondutoCreditCardPaymentStatus status) {
		this.status = status;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getLast4() {
		return last4;
	}

	public void setLast4(String last4) {
		this.last4 = last4;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoCreditCardPayment)) return false;

		KondutoCreditCardPayment that = (KondutoCreditCardPayment) o;

		if (bin != null ? !bin.equals(that.bin) : that.bin != null) return false;
		if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
			return false;
		if (last4 != null ? !last4.equals(that.last4) : that.last4 != null) return false;
		if (status != that.status) return false;

		return true;
	}
}
