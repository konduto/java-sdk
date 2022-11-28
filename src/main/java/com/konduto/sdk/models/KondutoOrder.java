package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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

    @SerializedName("messages_exchanged")
    private Integer messagesExchanged;

    @SerializedName("first_message")
    private String firstMessage;
    @SerializedName("purchased_at")
    private String purchasedAt;

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

    private Collection<KondutoBureauQuery> bureauxQueries;

    private Collection<KondutoTriggeredRule> triggeredRules;

    @SerializedName("triggered_decision_list")
    private Collection<KondutoTriggeredDecisionList> decisionListEntries;

    private KondutoDevice device;

    private KondutoExternalDevice externalDevice;

    @SerializedName("navigation")
    private KondutoNavigationInfo navigationInfo;

    private KondutoTravel travel;

    private KondutoOption options;
    private KondutoHotel hotel;

    private List<KondutoEvent> events;

    private KondutoVehicle vehicle;

    @SerializedName("delivery")
    private KondutoDelivery delivery;
    @SerializedName("point_of_sale")
    private KondutoPointOfSale pointOfSale;

    private KondutoAgentSeller agent;

    private KondutoBankOriginAccount originAccount;
    @SerializedName(value = "destination_accounts")
    private List<KondutoBankDestinationAccount> destinationAccounts;

    private KondutoTenant tenant;

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

        if (externalDevice != null ? !externalDevice.equals(order.externalDevice) : order.externalDevice != null) return false;

        if (navigationInfo != null ? !navigationInfo.equals(order.navigationInfo) : order.navigationInfo != null)
            return false;

        if (travel != null ? !travel.equals(order.travel) : order.travel != null)
            return false;

        if (messagesExchanged != null ? !messagesExchanged.equals(order.messagesExchanged) :
                order.messagesExchanged != null)
            return false;

        if (firstMessage != null ? !firstMessage.equals(order.firstMessage) : order.firstMessage != null) return false;
        if (purchasedAt != null ? !purchasedAt.equals(order.purchasedAt) : order.purchasedAt != null) return false;

        if (seller != null ? !seller.equals(order.seller) : order.seller != null) return false;

        if (options != null ? !options.equals(order.options) : order.options != null) return false;
        if (hotel != null ? !hotel.equals(order.hotel) : order.hotel != null) return false;

        if (delivery != null ? !delivery.equals(order.delivery) : order.delivery != null) return false;
        if (pointOfSale != null ? !pointOfSale.equals(order.pointOfSale) : order.pointOfSale != null) return false;
        if (agent != null ? !agent.equals(order.agent) : order.agent != null) return false;

        if (originAccount != null ? !originAccount.equals(order.originAccount) : order.originAccount != null)
            return false;
        if (destinationAccounts != null ? !destinationAccounts.equals(order.destinationAccounts) : order.destinationAccounts != null)
            return false;
        if (tenant != null ? !tenant.equals(order.tenant) : order.tenant != null) return false;

        return true;
    }

    /** getters and setters **/
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

    public KondutoExternalDevice getExternalDevice() {
        return externalDevice;
    }

    public void setExternalDevice(KondutoExternalDevice externalDevice) {
        this.externalDevice = externalDevice;
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
    public Integer getMessagesExchanged() { return messagesExchanged; }
    public void setMessagesExchanged(Integer messagesExchanged) { this.messagesExchanged = messagesExchanged; }
    public KondutoTravel getTravel() {
        return travel;
    }
    public void setTravel(KondutoTravel travel) {
        this.travel = travel;
    }
    public KondutoSeller getSeller() { return seller; }
    public void setSeller(KondutoSeller seller) { this.seller = seller; }

    public Date getFirstMessage() {
        return deserializeDate(firstMessage);
    }
    public Date getPurchasedAt() {
        return deserializeDate(purchasedAt);
    }
    public void setFirstMessage(Date first_message) {
        this.firstMessage = serializeDate(first_message);
    }
    public void setPurchasedAt(Date purchased_at) {
        this.purchasedAt = serializeDate(purchased_at);
    }
    public KondutoOption getOptions() {
        return options;
    }
    public void setOptions(KondutoOption options) {
        this.options = options;
    }
    public KondutoHotel getHotel() {
        return hotel;
    }
    public void setHotel(KondutoHotel hotel) {
        this.hotel = hotel;
    }
    public void setBureauxQueries(Collection<KondutoBureauQuery> bureauxQueries) {
        this.bureauxQueries = bureauxQueries;
    }

    public Collection<KondutoBureauQuery> getBureauxQueries() {
        return bureauxQueries;
    }

    public Collection<KondutoTriggeredRule> getTriggeredRules() {
        return triggeredRules;
    }

    public Collection<KondutoTriggeredDecisionList> getDecisionListEntries() {
        return decisionListEntries;
    }

    public List<KondutoEvent> getEvents() {
        return events;
    }

    public void setEvents(List<KondutoEvent> events) {
        this.events = events;
    }

    public KondutoVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(KondutoVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public KondutoDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(KondutoDelivery delivery) {
        this.delivery = delivery;
    }

    public KondutoPointOfSale getPointOfSale() {
        return pointOfSale;
    }
    public void setPointOfSale(KondutoPointOfSale pointOfSale){
        this.pointOfSale = pointOfSale;
    }
    public KondutoAgentSeller getAgent() {
        return  agent;
    }
    public void setAgent(KondutoAgentSeller agent){
        this.agent = agent;
    }

    public KondutoBankOriginAccount getOriginAccount() {
        return originAccount;
    }
    public void setOriginAccount(KondutoBankOriginAccount originAccount) {
        this.originAccount = originAccount;
    }
    public List<KondutoBankDestinationAccount> getDestinationAccounts() {
        return destinationAccounts;
    }
    public void setDestinationAccounts(List<KondutoBankDestinationAccount> destinationAccounts) {
        this.destinationAccounts = destinationAccounts;
    }
    public KondutoTenant getTenant() {
        return tenant;
    }
    public void setTenant(KondutoTenant tenant) {
        this.tenant = tenant;
    }
}
