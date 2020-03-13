package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing the types of documents Konduto's API accepts when handling event tickets attendee's
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoEventTicketAttendeeDocumentType {
    @SerializedName("cpf")
    CPF,
    @SerializedName("cnpj")
    CNPJ,
    @SerializedName("rg")
    RG,
    @SerializedName("passport")
    PASSPORT,
    @SerializedName("other")
    OTHER
}
