package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing the triggers for decision list entries.
 */
public enum KondutoDecisionListTrigger {
    /** Email address trigger */
    @SerializedName("email")
    EMAIL,
    /** Billing address trigger */
    @SerializedName("billing")
    BILLING,
    /** Shipping address trigger */
    @SerializedName("shipping")
    SHIPPING,
    /** Tax ID trigger */
    @SerializedName("tax_id")
    TAX_ID,
    /** Primary phone number trigger */
    @SerializedName("phone_1")
    PHONE_1,
    /** Secondary phone number trigger */
    @SerializedName("phone_2")
    PHONE_2,
    /** IP address trigger */
    @SerializedName("ip")
    IP,
    /** Shipping ZIP code trigger */
    @SerializedName("shipping_zip")
    SHIPPING_ZIP,
    /** Billing ZIP code trigger */
    @SerializedName("billing_zip")
    BILLING_ZIP,
    /** Hotel ZIP code trigger */
    @SerializedName("hotel_zip")
    HOTEL_ZIP,
    /** Customer name trigger */
    @SerializedName("customer_name")
    CUSTOMER_NAME,
    /** Shipping name trigger */
    @SerializedName("shipping_name")
    SHIPPING_NAME,
    /** Billing name trigger */
    @SerializedName("billing_name")
    BILLING_NAME,
    /** Last 4 digits of card BIN trigger */
    @SerializedName("bin_last4")
    BIN_LAST4,
    /** Passenger name trigger */
    @SerializedName("passenger_name")
    PASSENGER_NAME,
    /** Passenger document trigger */
    @SerializedName("passenger_document")
    PASSENGER_DOCUMENT,
    /** Guest name trigger */
    @SerializedName("guest_name")
    GUEST_NAME,
    /** Guest document trigger */
    @SerializedName("guest_document")
    GUEST_DOCUMENT,
    /** Device IP address trigger */
    @SerializedName("device_ip")
    DEVICE_IP
}