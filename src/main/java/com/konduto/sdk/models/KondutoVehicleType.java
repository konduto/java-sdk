package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Vehicle Types
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoVehicleType {
    @SerializedName("car")
    CAR,
    @SerializedName("bus")
    BUS,
    @SerializedName("truck")
    TRUCK,
    @SerializedName("motorcycle")
    MOTORCYCLE,
    @SerializedName("bicycle")
    BICYCLE,
    @SerializedName("aircraft")
    AIRCRAFT,
    @SerializedName("boat")
    BOAT
}
