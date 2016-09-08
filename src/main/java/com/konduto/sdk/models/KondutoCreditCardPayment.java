package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 *
 * Credit card model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoCreditCardPayment extends KondutoPayment {

	private String bin;

	private String last4;

	private String expirationDate;

    @Required private KondutoPaymentStatus status;

    public KondutoPaymentStatus getStatus() {
        return status;
    }

    public void setStatus(KondutoPaymentStatus status) {
        this.status = status;
    }

    public String getStatusAsString() {
        if(getStatus() == null) { throw new RuntimeException("Payment status cannot be null"); }
        return getStatus().toString().toLowerCase();
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
	public KondutoPaymentType getType() {
		return KondutoPaymentType.CREDIT;
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
        return status == that.status;

    }

	/* This is required for correct deserialization since HashSet uses hashCode instead of equals. */
	@Override
	public int hashCode() {
		int result = bin != null ? bin.hashCode() : 0;
		result = 31 * result + (last4 != null ? last4.hashCode() : 0);
		result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (getType()!= null ? getType().hashCode() : 0);
		return result;
	}
}
