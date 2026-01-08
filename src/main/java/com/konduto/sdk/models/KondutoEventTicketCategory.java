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
    /** Student ticket category */
    @SerializedName("student")
    STUDENT,
    /** Senior citizen ticket category */
    @SerializedName("senior")
    SENIOR,
    /** Government employee ticket category */
    @SerializedName("government")
    GOVERNMENT,
    /** Social program ticket category */
    @SerializedName("social")
    SOCIAL,
    /** Regular ticket category */
    @SerializedName("regular")
    REGULAR
}
