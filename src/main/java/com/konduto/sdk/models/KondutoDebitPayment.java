package com.konduto.sdk.models;

/**
 * Represents a debit payment in the Konduto system.
 * This class extends KondutoPayment and includes debit card specific attributes.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoDebitPayment extends KondutoPayment {

    /**
     * Default constructor.
     */
    public KondutoDebitPayment() {
    }

    private String sha1;

    private String bin;

    private String last4;

    private String expirationDate;

    private String cvvResult;

    private String avsResult;

    private Integer numberOfRetries;

    private String taxId;

    private KondutoPaymentStatus status;

	/**
	 * Gets the SHA1 hash of the debit card number.
	 *
	 * @return the SHA1 hash of the debit card number
	 */
    public String getSha1() {
        return sha1;
    }

	/**
	 * Sets the SHA1 hash of the debit card number.
	 *
	 * @param sha1 the SHA1 hash of the debit card number
	 */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

	/**
	 * Gets the first 6 digits (BIN) of the debit card number.
	 *
	 * @return the BIN of the debit card
	 */
    public String getBin() {
        return bin;
    }

	/**
	 * Sets the first 6 digits (BIN) of the debit card number.
	 *
	 * @param bin the BIN of the debit card
	 */
    public void setBin(String bin) {
        this.bin = bin;
    }

	/**
	 * Gets the last 4 digits of the debit card number.
	 *
	 * @return the last 4 digits of the debit card
	 */
    public String getLast4() {
        return last4;
    }

	/**
	 * Sets the last 4 digits of the debit card number.
	 *
	 * @param last4 the last 4 digits of the debit card
	 */
    public void setLast4(String last4) {
        this.last4 = last4;
    }

	/**
	 * Gets the expiration date of the debit card.
	 *
	 * @return the expiration date
	 */
    public String getExpirationDate() {
        return expirationDate;
    }

	/**
	 * Sets the expiration date of the debit card.
	 *
	 * @param expirationDate the expiration date
	 */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
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
	 * Gets the tax identification number associated with the debit card.
	 *
	 * @return the tax ID
	 */
    public String getTaxId() {
        return taxId;
    }

	/**
	 * Sets the tax identification number associated with the debit card.
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
        return getStatus() == null ?
                null :
                getStatus().toString().toLowerCase();
    }

    @Override
    public KondutoPaymentType getType() {
        return KondutoPaymentType.DEBIT;
    }
}
