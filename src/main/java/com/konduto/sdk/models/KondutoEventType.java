package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing the types of events Konduto's API currently supports.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoEventType {
    /** Show event type */
    @SerializedName("show")
    SHOW,
    /** Theater event type */
    @SerializedName("theater")
    THEATER,
    /** Movies event type */
    @SerializedName("movies")
    MOVIES,
    /** Party event type */
    @SerializedName("party")
    PARTY,
    /** Festival event type */
    @SerializedName("festival")
    FESTIVAL,
    /** Course event type */
    @SerializedName("course")
    COURSE,
    /** Sports event type */
    @SerializedName("sports")
    SPORTS,
    /** Corporate event type */
    @SerializedName("corporate")
    CORPORATE
}
