package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing document types.
 */
public enum KondutoDocumentType {
    /** ID document type */
    @SerializedName("id")
    ID,
    /** Passport document type */
    @SerializedName("passport")
    PASSPORT
}
