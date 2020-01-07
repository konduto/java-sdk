package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum KondutoDecisionListTrigger {
    @SerializedName("email")
    EMAIL,
    @SerializedName("billing")
    BILLING,
    @SerializedName("shipping")
    SHIPPING,
    @SerializedName("tax_id")
    TAX_ID,
    @SerializedName("phone_1")
    PHONE_1,
    @SerializedName("phone_2")
    PHONE_2,
    @SerializedName("ip")
    IP,
    @SerializedName("shipping_zip")
    SHIPPING_ZIP,
    @SerializedName("billing_zip")
    BILLING_ZIP,
    @SerializedName("hotel_zip")
    HOTEL_ZIP,
    @SerializedName("customer_name")
    CUSTOMER_NAME,
    @SerializedName("shipping_name")
    SHIPPING_NAME,
    @SerializedName("billing_name")
    BILLING_NAME,
    @SerializedName("bin_last4")
    BIN_LAST4,
    @SerializedName("passenger_name")
    PASSENGER_NAME,
    @SerializedName("passenger_document")
    PASSENGER_DOCUMENT,
    @SerializedName("guest_name")
    GUEST_NAME,
    @SerializedName("guest_document")
    GUEST_DOCUMENT,
    @SerializedName("device_ip")
    DEVICE_IP
}