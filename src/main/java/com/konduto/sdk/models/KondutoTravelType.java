package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Travel types.
 */
public enum KondutoTravelType {
    @SerializedName(value = "bus")
    BUS,
    @SerializedName(value = "flight")
    FLIGHT
}
