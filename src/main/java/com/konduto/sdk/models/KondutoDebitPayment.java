package com.konduto.sdk.models;

/**
 * Created by rsampaio on 9/6/16.
 */
public class KondutoDebitPayment extends KondutoPayment {

    private String sha1;

    private String bin;

    private String last4;

    private String expirationDate;

    private String cvvResult;

    private String avsResult;

    private Integer numberOfRetries;

    private String taxId;

    private KondutoPaymentStatus status;

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
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

    public String getCvvResult() {
        return cvvResult;
    }

    public void setCvvResult(String cvvResult) {
        this.cvvResult = cvvResult;
    }

    public String getAvsResult() {
        return avsResult;
    }

    public void setAvsResult(String avsResult) {
        this.avsResult = avsResult;
    }

    public Integer getNumberOfRetries() {
        return numberOfRetries;
    }

    public void setNumberOfRetries(Integer numberOfRetries) {
        this.numberOfRetries = numberOfRetries;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public KondutoPaymentStatus getStatus() {
        return status;
    }

    public void setStatus(KondutoPaymentStatus status) {
        this.status = status;
    }

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
