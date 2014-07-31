package com.konduto.sdk.models;

import org.json.JSONObject;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoOrder extends KondutoModel {

	private String id;
	private String visitor;
	private String timestamp;
	private Double totalAmount;
	private Double shippingAmount;
	private Double taxAmount;
	private String currency;
	private Integer installments;
	private String ip;
	private Double score;
	private KondutoCustomer customer;

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
	protected JSONObject toJSON() {
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
		if(this.customer != null) { json.put("customer", this.customer.toJSON()); }
		return json;
	}

	protected static KondutoOrder fromJSON(JSONObject json) {
		KondutoOrder order = new KondutoOrder();
		// required fields
		order.setId(json.getString("id"));
		order.setTotalAmount(json.getDouble("total_amount"));
		order.setCustomer(KondutoCustomer.fromJSON(json.getJSONObject("customer")));

		// optional fields
		if(json.has("visitor")) { order.setVisitor(json.getString("visitor")); }
		if(json.has("timestamp")) { order.setTimestamp(json.getString("timestamp")); }
		if(json.has("shipping_amount")) { order.setShippingAmount(json.getDouble("shipping_amount")); }
		if(json.has("tax_amount")) { order.setTaxAmount(json.getDouble("tax_amount")); }
		if(json.has("currency")) { order.setCurrency(json.getString("currency")); }
		if(json.has("installments")) { order.setInstallments(json.getInt("installments")); }
		if(json.has("ip")) { order.setIp(json.getString("ip")); }
		if(json.has("score")) { order.setScore(json.getDouble("score")); }

		return order;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
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
}
