package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing the types of events Konduto's API currently supports.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoEventType {
    @SerializedName("show")
    SHOW,
    @SerializedName("theater")
    THEATER,
    @SerializedName("movies")
    MOVIES,
    @SerializedName("party")
    PARTY,
    @SerializedName("festival")
    FESTIVAL,
    @SerializedName("course")
    COURSE,
    @SerializedName("sports")
    SPORTS,
    @SerializedName("corporate")
    CORPORATE
}
