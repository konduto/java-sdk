package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Travel classes
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoTravelClass {
    @SerializedName(value = "economy")
    ECONOMY,
    @SerializedName(value = "business")
    BUSINESS,
    @SerializedName(value = "first")
    FIRST
}
