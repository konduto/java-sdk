package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Travel classes
 */
public enum KondutoTravelClass {
    @SerializedName(value = "economy")
    ECONOMY,
    @SerializedName(value = "business")
    BUSINESS,
    @SerializedName(value = "first")
    FIRST
}
