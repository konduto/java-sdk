package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

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
