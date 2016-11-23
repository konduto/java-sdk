package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrealves on 11/22/16.
 */
public enum KondutoGuestDocumentType {
    @SerializedName("id")
    ID,
    @SerializedName("passport")
    PASSPORT,
    @SerializedName("rg")
    RG,
    @SerializedName("cpf")
    CPF,
    @SerializedName("other")
    other
}