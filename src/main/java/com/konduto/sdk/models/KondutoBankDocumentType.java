package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 08/06/2022.
 * Enumeration of supported PIX key types for Brazilian bank accounts.
 */
public enum KondutoBankDocumentType {

    /**
     * PIX key using CPF (Individual Taxpayer ID)
     */
    @SerializedName("pix_cpf")
    PIX_CPF,
    /**
     * PIX key using CNPJ (Corporate Taxpayer ID)
     */
    @SerializedName("pix_cnpj")
    PIX_CNPJ,
    /**
     * PIX key using phone number
     */
    @SerializedName("pix_phone")
    PIX_PHONE,
    /**
     * PIX key using email address
     */
    @SerializedName("pix_email")
    PIX_EMAIL,
    /**
     * PIX key using EVP (End-to-End Identifier)
     */
    @SerializedName("pix_evp")
    PIX_EVP,
    /**
     * P2P (Person-to-Person) transfer
     */
    @SerializedName("p2p")
    P2P,
    /**
     * No specific key type
     */
    @SerializedName("none")
    NONE
}