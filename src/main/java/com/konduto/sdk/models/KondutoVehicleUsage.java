package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Vehicle usage
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoVehicleUsage {
    @SerializedName("private")
    PRIVATE,
    @SerializedName("commercial")
    COMMERCIAL,
    @SerializedName("instruction")
    INSTRUCTION,
    @SerializedName("experimental")
    EXPERIMENTAL,
    @SerializedName("government")
    GOVERNMENT,
    @SerializedName("military")
    MILITARY
}
