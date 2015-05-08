package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Travel types.
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoTravelType {
    @SerializedName(value = "bus")
    BUS,
    @SerializedName(value = "flight")
    FLIGHT
}
