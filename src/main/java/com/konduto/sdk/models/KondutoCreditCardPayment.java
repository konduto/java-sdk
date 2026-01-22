package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 * Represents a credit card payment in the Konduto system.
 * This class extends KondutoPayment and includes credit card specific attributes.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoCreditCardPayment extends KondutoPayment {

    /**
     * Default constructor.
     */
    public KondutoCreditCardPayment() {
    }

    private String sha1;

    private String bin;

    private String last4;

    private String expirationDate;

    private String cvvResult;

    private String avsResult;

    private Integer numberOfRetries;

    private String taxId;

    @Required private KondutoPaymentStatus status;

	/**
	 * Gets the SHA1 hash of the credit card number.
	 *
	 * @return the SHA1 hash of the credit card number
	 */
    public String getSha1() {
        return sha1;
    }

	/**
	 * Sets the SHA1 hash of the credit card number.
	 *
	 * @param sha1 the SHA1 hash of the credit card number
	 */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

	/**
	 * Gets the CVV verification result.
	 *
	 * @return the CVV verification result
	 */
    public String getCvvResult() {
        return cvvResult;
    }

	/**
	 * Sets the CVV verification result.
	 *
	 * @param cvvResult the CVV verification result
	 */
    public void setCvvResult(String cvvResult) {
        this.cvvResult = cvvResult;
    }

	/**
	 * Gets the AVS (Address Verification System) result.
	 *
	 * @return the AVS result
	 */
    public String getAvsResult() {
        return avsResult;
    }

	/**
	 * Sets the AVS (Address Verification System) result.
	 *
	 * @param avsResult the AVS result
	 */
    public void setAvsResult(String avsResult) {
        this.avsResult = avsResult;
    }

	/**
	 * Gets the number of payment retries.
	 *
	 * @return the number of payment retries
	 */
    public Integer getNumberOfRetries() {
        return numberOfRetries;
    }

	/**
	 * Sets the number of payment retries.
	 *
	 * @param numberOfRetries the number of payment retries
	 */
    public void setNumberOfRetries(Integer numberOfRetries) {
        this.numberOfRetries = numberOfRetries;
    }

	/**
	 * Gets the tax identification number associated with the credit card.
	 *
	 * @return the tax ID
	 */
    public String getTaxId() {
        return taxId;
    }

	/**
	 * Sets the tax identification number associated with the credit card.
	 *
	 * @param taxId the tax ID
	 */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

	/**
	 * Gets the payment status.
	 *
	 * @return the payment status
	 */
    public KondutoPaymentStatus getStatus() {
        return status;
    }

	/**
	 * Sets the payment status.
	 *
	 * @param status the payment status
	 */
    public void setStatus(KondutoPaymentStatus status) {
        this.status = status;
    }

	/**
	 * Gets the payment status as a lowercase string.
	 *
	 * @return the payment status as a string
	 */
    public String getStatusAsString() {
        if(getStatus() == null) { throw new RuntimeException("Payment status cannot be null"); }
        return getStatus().toString().toLowerCase();
    }

	/**
	 * Gets the first 6 digits (BIN) of the credit card number.
	 *
	 * @return the BIN of the credit card
	 */
    public String getBin() {
        return bin;
    }

	/**
	 * Sets the first 6 digits (BIN) of the credit card number.
	 *
	 * @param bin the BIN of the credit card
	 */
    public void setBin(String bin) {
        this.bin = bin;
    }

	/**
	 * Gets the last 4 digits of the credit card number.
	 *
	 * @return the last 4 digits of the credit card
	 */
    public String getLast4() {
        return last4;
    }

	/**
	 * Sets the last 4 digits of the credit card number.
	 *
	 * @param last4 the last 4 digits of the credit card
	 */
    public void setLast4(String last4) {
        this.last4 = last4;
    }

	/**
	 * Gets the expiration date of the credit card.
	 *
	 * @return the expiration date
	 */
    public String getExpirationDate() {
        return expirationDate;
    }

	/**
	 * Sets the expiration date of the credit card.
	 *
	 * @param expirationDate the expiration date
	 */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public KondutoPaymentType getType() {
        return KondutoPaymentType.CREDIT;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
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
