package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;

/**
 * Created by rsampaio on 31/07/14.
 */
public final class KondutoOrder extends KondutoModel {

	private String id;
	private String visitor;
	private Long timestamp;
	private Double totalAmount;
	private Double shippingAmount;
	private Double taxAmount;
	private String currency;
	private Integer installments;
	private String ip;
	private Double score;
	private KondutoCustomer customer;
	private KondutoRecommendation recommendation;
	private KondutoGeolocation geolocation;
	private KondutoAddress shippingAddress;
	private KondutoAddress billingAddress;

	public KondutoOrderStatus getOrderStatus() {
		return orderStatus;
	}

	protected void setOrderStatus(KondutoOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	private KondutoOrderStatus orderStatus;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoOrder)) return false;

		KondutoOrder that = (KondutoOrder) o;

		if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
		if (!customer.equals(that.customer)) return false;
		if (!id.equals(that.id)) return false;
		if (installments != null ? !installments.equals(that.installments) : that.installments != null) return false;
		if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
		if (score != null ? !score.equals(that.score) : that.score != null) return false;
		if (shippingAmount != null ? !shippingAmount.equals(that.shippingAmount) : that.shippingAmount != null)
			return false;
		if (taxAmount != null ? !taxAmount.equals(that.taxAmount) : that.taxAmount != null) return false;
		if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
		if (!totalAmount.equals(that.totalAmount)) return false;
		if (visitor != null ? !visitor.equals(that.visitor) : that.visitor != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (visitor != null ? visitor.hashCode() : 0);
		result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
		result = 31 * result + totalAmount.hashCode();
		result = 31 * result + (shippingAmount != null ? shippingAmount.hashCode() : 0);
		result = 31 * result + (taxAmount != null ? taxAmount.hashCode() : 0);
		result = 31 * result + (currency != null ? currency.hashCode() : 0);
		result = 31 * result + (installments != null ? installments.hashCode() : 0);
		result = 31 * result + (ip != null ? ip.hashCode() : 0);
		result = 31 * result + (score != null ? score.hashCode() : 0);
		result = 31 * result + customer.hashCode();
		return result;
	}

	@Override
	public boolean isValid() {
		errors.clear();
		if(this.id == null || this.id.isEmpty()) { isRequiredError("id"); }
		if(this.totalAmount == null) { isRequiredError("totalAmount"); }
		if(this.customer == null) {
			isRequiredError("customer");
		} else {
			if(!this.customer.isValid()) { isInvalidError("customer"); }
		}
		return errors.isEmpty();
	}

	@Override
	public JSONObject toJSON() throws KondutoInvalidEntityException {
		if(!this.isValid()){ throw new KondutoInvalidEntityException(this); }
		JSONObject json = new JSONObject();
		json.put("id", this.id);
		json.put("visitor", this.visitor);
		json.put("timestamp", this.timestamp);
		json.put("total_amount", this.totalAmount);
		json.put("shipping_amount", this.shippingAmount);
		json.put("tax_amount", this.taxAmount);
		json.put("currency", this.currency);
		json.put("installments", this.installments);
		json.put("ip", this.ip);
		json.put("score", this.score);

		if(this.customer != null) {
			try {
				json.put("customer", this.customer.toJSON());
			} catch (KondutoInvalidEntityException e) {
				throw e;
			}
		}
		return json;
	}

	public KondutoOrder(){}

	public KondutoGeolocation getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(KondutoGeolocation geolocation) {
		this.geolocation = geolocation;
	}

	public KondutoAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(KondutoAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public KondutoAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(KondutoAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public KondutoOrder(JSONObject json){
		this.fromJSON(json);
	}

	public void fromJSON(JSONObject json) {
		if(json.has("order")) { json = json.getJSONObject("order"); } // unwrap if necessary

		// required fields
		this.id = json.getString("id");
		this.totalAmount = json.getDouble("total_amount");
		this.customer = new KondutoCustomer(json.getJSONObject("customer"));

		// optional fields
		if(json.has("visitor")) { this.visitor = json.getString("visitor"); }
		if(json.has("timestamp")) { this.timestamp = json.getLong("timestamp"); }
		if(json.has("shipping_amount")) { this.shippingAmount = json.getDouble("shipping_amount"); }
		if(json.has("tax_amount")) { this.taxAmount = json.getDouble("tax_amount"); }
		if(json.has("currency")) { this.currency = json.getString("currency"); }
		if(json.has("installments")) { this.installments = json.getInt("installments"); }
		if(json.has("ip")) { this.ip = json.getString("ip"); }
		if(json.has("score")) { this.score = json.getDouble("score"); }
		if(json.has("recommendation")) {
			this.recommendation = KondutoRecommendation.fromString(json.getString("recommendation"));
		}
		if(json.has("status")) { this.orderStatus = KondutoOrderStatus.fromString(json.getString("status")); }
		if(json.has("geolocation")) { this.geolocation = new KondutoGeolocation(json.getJSONObject("geolocation")); }
		if(json.has("shipping")) { this.shippingAddress = new KondutoAddress(json.getJSONObject("shipping")); }
		if(json.has("billing")) { this.billingAddress = new KondutoAddress(json.getJSONObject("billing")); }
	}


	public KondutoRecommendation getRecommendation() {
		return recommendation;
	}

	public Double getScore() {
		return score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public KondutoCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(KondutoCustomer customer) {
		this.customer = customer;
	}

	protected void setScore(Double score) {
		this.score = score;
	}

	protected void setRecommendation(KondutoRecommendation recommendation) {
		this.recommendation = recommendation;
	}
}
