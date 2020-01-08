package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum KondutoDecisionListType {
    @SerializedName("email")
    EMAIL,
    @SerializedName("tax_id")
    TAX_ID,
    @SerializedName("phone")
    PHONE,
    @SerializedName("bin_last4")
    BIN_LAST4,
    @SerializedName("zip")
    ZIP,
    @SerializedName("name")
    NAME,
    @SerializedName("ip")
    IP
}
