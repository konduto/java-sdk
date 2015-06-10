package com.konduto.sdk.models;

import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * Order model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public final class KondutoOrder extends KondutoModel {
	/* Attributes */
	@Required
	private String id;

	private String visitor;

	private Long timestamp;

	@Required
	private Double totalAmount;

	private Double shippingAmount;
	private Double taxAmount;

	@Required
	private KondutoCustomer customer;

	private String currency;

	private Integer installments;

	private String ip;

	private Double score;

	@SerializedName("shipping")
	private KondutoAddress shippingAddress;

	@SerializedName("billing")
	private KondutoAddress billingAddress;

	private KondutoRecommendation recommendation;

	private KondutoOrderStatus status;

	private KondutoGeolocation geolocation;

    private boolean analyze = true;

	private Integer messages_exchanged;

//	@ValidateFormat(format="^\\d{4}-\\d{2}-\\d{2}")
	private String first_message;
//	@ValidateFormat(format="^\\d{4}-\\d{2}-\\d{2}")
	private String purchased_at;

	private KondutoSeller seller;

	@SerializedName("payment")
	/**
	 *  when deserialized, this collection is a HashSet by default.
	 */
	private Collection<KondutoPayment> payments;

	/**
	 *  when deserialized, this collection is an ArrayList by default.
	 */
	private Collection<KondutoItem> shoppingCart;

	private KondutoDevice device;

	@SerializedName("navigation")
	private KondutoNavigationInfo navigationInfo;

	private KondutoTravel travel;

	/* Constructors */
	public KondutoOrder() {}

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoOrder with(String attributeName, Object attributeValue) {
		return (KondutoOrder) super.with(attributeName, attributeValue);
	}

	/* equals */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoOrder)) return false;
		KondutoOrder order = (KondutoOrder) o;
		if (billingAddress != null ? !billingAddress.equals(order.billingAddress) : order.billingAddress != null)
			return false;
		if (currency != null ? !currency.equals(order.currency) : order.currency != null) return false;
		if (!customer.equals(order.customer)) return false;

		if (geolocation != null ? !geolocation.equals(order.geolocation) : order.geolocation != null) return false;

		if (!id.equals(order.id)) return false;

		if (installments != null ? !installments.equals(order.installments) : order.installments != null) return false;

		if (ip != null ? !ip.equals(order.ip) : order.ip != null) return false;

		if (recommendation != order.recommendation) return false;

		if (score != null ? !score.equals(order.score) : order.score != null) return false;

		if (shippingAddress != null ? !shippingAddress.equals(order.shippingAddress) : order.shippingAddress != null)
			return false;

		if (shippingAmount != null ? !shippingAmount.equals(order.shippingAmount) : order.shippingAmount != null)
			return false;

		if (status != order.status) return false;

		if (taxAmount != null ? !taxAmount.equals(order.taxAmount) : order.taxAmount != null) return false;

		if (timestamp != null ? !timestamp.equals(order.timestamp) : order.timestamp != null) return false;

		if (!totalAmount.equals(order.totalAmount)) return false;

		if (visitor != null ? !visitor.equals(order.visitor) : order.visitor != null) return false;

		if (payments != null ? !payments.equals(order.payments) : order.payments != null)
			return false;

		if (shoppingCart != null ? !shoppingCart.equals(order.shoppingCart) : order.shoppingCart != null)
			return false;

		if (device != null ? !device.equals(order.device) : order.device != null) return false;

		if (navigationInfo != null ? !navigationInfo.equals(order.navigationInfo) : order.navigationInfo != null)
			return false;

		if (travel != null ? !travel.equals(order.travel) : order.travel != null)
			return false;

		if (messages_exchanged != null ? messages_exchanged != order.messages_exchanged :
				order.messages_exchanged != null)
			return false;

		if (first_message != null ? !first_message.equals(order.first_message) : order.first_message != null) return false;
		if (purchased_at != null ? !purchased_at.equals(order.purchased_at) : order.purchased_at!= null) return false;

		if (seller != null ? !seller.equals(order.seller) : order.seller != null) return false;

		return true;
	}

	/* getters and setters */
	public KondutoNavigationInfo getNavigationInfo() {
		return navigationInfo;
	}
	public void setNavigationInfo(KondutoNavigationInfo navigationInfo) {
		this.navigationInfo = navigationInfo;
	}
	public KondutoDevice getDevice() {
		return device;
	}
	public void setDevice(KondutoDevice device) {
		this.device = device;
	}
	public Collection<KondutoItem> getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(Collection<KondutoItem> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public Collection<KondutoPayment> getPayments() {
		return payments;
	}
	public void setPayments(Collection<KondutoPayment> payments) {
		this.payments = payments;
	}
	public KondutoOrderStatus getStatus() {
		return status;
	}
	public void setStatus(KondutoOrderStatus status) {
		this.status = status;
	}
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
	public void setScore(Double score) {
		this.score = score;
	}
	public void setRecommendation(KondutoRecommendation recommendation) {
		this.recommendation = recommendation;
	}
    public boolean getAnalyze() { return analyze; }
    public void setAnalyze(boolean analyze) { this.analyze = analyze; }
	public Integer getMessages_exchanged() { return messages_exchanged; }
	public void setMessages_exchanged(Integer messages_exchanged) { this.messages_exchanged = messages_exchanged; }
	public KondutoTravel getTravel() {
		return travel;
	}
	public void setTravel(KondutoTravel travel) {
		this.travel = travel;
	}
	public KondutoSeller getSeller() { return seller; }
	public void setSeller(KondutoSeller seller) { this.seller = seller; }

	public Date getFirst_message() {
		return deserializeDate(first_message);
	}
	public Date getPurchased_at() {
		return deserializeDate(purchased_at);
	}
	public void setFirst_message(Date first_message) {
		this.first_message = serializeDate(first_message);
	}
	public void setPurchased_at(Date purchased_at) {
		this.purchased_at = serializeDate(purchased_at);
	}

	public static final String dateFormat = "yyyy-MM-dd'T'HH:mmZ";

	private Date deserializeDate(String date) throws JsonParseException {
		try {
			Calendar calendar = javax.xml.bind.DatatypeConverter.parseDateTime(date);
			Date d = calendar.getTime();
			return new SimpleDateFormat(dateFormat, Locale.US).parse(date);
		} catch (ParseException e) {
		}
		throw new JsonParseException("Unparseable date: \"" + date
				+ "\". Supported format: " + dateFormat);
	}

	private String serializeDate(Date src) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return  sdf.format(src).replace("+0000", "Z");
	}
}