package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing the types of decision list entries.
 */
public enum KondutoDecisionListType {
    /** Email address type */
    @SerializedName("email")
    EMAIL,
    /** Tax ID type */
    @SerializedName("tax_id")
    TAX_ID,
    /** Phone number type */
    @SerializedName("phone")
    PHONE,
    /** Last 4 digits of card BIN type */
    @SerializedName("bin_last4")
    BIN_LAST4,
    /** ZIP code type */
    @SerializedName("zip")
    ZIP,
    /** Name type */
    @SerializedName("name")
    NAME,
    /** IP address type */
    @SerializedName("ip")
    IP
}
