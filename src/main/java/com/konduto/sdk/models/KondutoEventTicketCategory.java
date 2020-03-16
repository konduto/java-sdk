package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing a event ticket category.
 * For instance, if the ticket was bought by a student it will probably have a discount. The same applies to
 * senior citizens.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoEventTicketCategory {
    @SerializedName("student")
    STUDENT,
    @SerializedName("senior")
    SENIOR,
    @SerializedName("government")
    GOVERNMENT,
    @SerializedName("social")
    SOCIAL,
    @SerializedName("regular")
    REGULAR
}
