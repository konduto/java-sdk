package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing the types of documents Konduto's API accepts when handling event tickets attendee's
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoEventTicketAttendeeDocumentType {
    /** CPF (Brazilian individual taxpayer ID) */
    @SerializedName("cpf")
    CPF,
    /** CNPJ (Brazilian corporate taxpayer ID) */
    @SerializedName("cnpj")
    CNPJ,
    /** RG (Brazilian national ID card) */
    @SerializedName("rg")
    RG,
    /** Passport */
    @SerializedName("passport")
    PASSPORT,
    /** Other document type */
    @SerializedName("other")
    OTHER
}
