package com.konduto.sdk.models;

/**
 * Delivery model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoDelivery extends KondutoModel {

    /**
     * Default constructor.
     */
    public KondutoDelivery() {
    }

    private String estimatedDeliveryDate;
    private String estimatedShippingDate;
    private String deliveryCompany;
    private String deliveryMethod;

	/**
	 * Gets the estimated delivery date.
	 *
	 * @return the estimated delivery date
	 */
    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

	/**
	 * Sets the estimated delivery date.
	 *
	 * @param estimatedDeliveryDate the estimated delivery date
	 */
    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

	/**
	 * Gets the estimated shipping date.
	 *
	 * @return the estimated shipping date
	 */
    public String getEstimatedShippingDate() {
        return estimatedShippingDate;
    }

	/**
	 * Sets the estimated shipping date.
	 *
	 * @param estimatedShippingDate the estimated shipping date
	 */
    public void setEstimatedShippingDate(String estimatedShippingDate) {
        this.estimatedShippingDate = estimatedShippingDate;
    }

	/**
	 * Gets the delivery company.
	 *
	 * @return the delivery company
	 */
    public String getDeliveryCompany() {
        return deliveryCompany;
    }

	/**
	 * Sets the delivery company.
	 *
	 * @param deliveryCompany the delivery company
	 */
    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

	/**
	 * Gets the delivery method.
	 *
	 * @return the delivery method
	 */
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

	/**
	 * Sets the delivery method.
	 *
	 * @param deliveryMethod the delivery method
	 */
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public KondutoDelivery with(String attributeName, Object attributeValue) {
        return (KondutoDelivery) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof KondutoDelivery)) return false;

        KondutoDelivery that = (KondutoDelivery) o;

        if (estimatedDeliveryDate != null ? !estimatedDeliveryDate.equals(that.estimatedDeliveryDate) : that.estimatedDeliveryDate != null)
            return false;
        if (estimatedShippingDate != null ? !estimatedShippingDate.equals(that.estimatedShippingDate) : that.estimatedShippingDate != null)
            return false;
        if (deliveryCompany != null ? !deliveryCompany.equals(that.deliveryCompany) : that.deliveryCompany != null)
            return false;
        if (deliveryMethod != null ? !deliveryMethod.equals(that.deliveryMethod) : that.deliveryMethod != null)
            return false;

        return true;
    }
}
