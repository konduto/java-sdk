package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum representing different types of guest documents.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoGuestDocumentType {
    /**
     * ID document.
     */
    @SerializedName("id")
    ID,
    /**
     * Passport document.
     */
    @SerializedName("passport")
    PASSPORT,
    /**
     * RG (Registro Geral) document.
     */
    @SerializedName("rg")
    RG,
    /**
     * CPF (Cadastro de Pessoas Físicas) document.
     */
    @SerializedName("cpf")
    CPF,
    /**
     * Other type of document.
     */
    @SerializedName("other")
    other
}