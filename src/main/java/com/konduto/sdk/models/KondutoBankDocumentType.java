package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrealves on 11/22/16.
 */
public enum KondutoBankDocumentType {

    @SerializedName("pix_cpf")
    PIX_CPF,
    @SerializedName("pix_cnpj")
    PIX_CNPJ,
    @SerializedName("pix_phone")
    PIX_PHONE,
    @SerializedName("pix_email")
    PIX_EMAIL,
    @SerializedName("pix_evp")
    PIX_EVP,
    @SerializedName("p2p")
    P2P,
    @SerializedName("none")
    NONE
}