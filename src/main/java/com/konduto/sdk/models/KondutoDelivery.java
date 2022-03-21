package com.konduto.sdk.models;

public class KondutoDelivery extends KondutoModel {

    private String estimatedDeliveryDate;
    private String estimatedShippingDate;
    private String deliveryCompany;
    private String deliveryMethod;

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getEstimatedShippingDate() {
        return estimatedShippingDate;
    }

    public void setEstimatedShippingDate(String estimatedShippingDate) {
        this.estimatedShippingDate = estimatedShippingDate;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

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
