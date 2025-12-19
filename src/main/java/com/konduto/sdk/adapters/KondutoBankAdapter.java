package com.konduto.sdk.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konduto.sdk.models.KondutoBank;
import com.konduto.sdk.models.KondutoBankOriginAccount;

import java.lang.reflect.Type;

/**
 * KondutoBankAdapter to serialize KondutoBank objects to JSON.
 */
public class KondutoBankAdapter implements JsonSerializer<KondutoBank> {

    /**
     * Default constructor.
     */
    public KondutoBankAdapter() {
    }

    /**
     * Serializes a KondutoBank object into a JSON element.
     * This method converts the properties of the KondutoBank instance into a JsonObject,
     * handling null values appropriately. If the bank is an instance of KondutoBankOriginAccount,
     * it delegates to KondutoBankOriginAccountAdapter for additional serialization.
     *
     * @param bank the KondutoBank object to serialize
     * @param typeOfSrc the type of the source object
     * @param context the serialization context
     * @return the serialized JsonElement
     */
    @Override
    public JsonElement serialize(KondutoBank bank, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        // Add bank properties to JSON object if they are not null
        if (bank.getId() != null) {
            json.addProperty("id", bank.getId());
        }
        if (bank.getKeyType() != null) {
            json.addProperty("key_type", bank.getKeyType().toString().toLowerCase());
        }
        if (bank.getKeyValue() != null) {
            json.addProperty("key_value", bank.getKeyValue());
        }
        if (bank.getHolderName() != null) {
            json.addProperty("holder_name", bank.getHolderName());
        }
        if (bank.getHolderTaxId() != null) {
            json.addProperty("holder_tax_id", bank.getHolderTaxId());
        }
        if (bank.getBankCode() != null) {
            json.addProperty("bank_code", bank.getBankCode());
        }
        if (bank.getBankName() != null) {
            json.addProperty("bank_name", bank.getBankName());
        }
        if (bank.getBankBranch() != null) {
            json.addProperty("bank_branch", bank.getBankBranch());
        }
        if (bank.getBankAccount() != null) {
            json.addProperty("bank_account", bank.getBankAccount());
        }
        // If the bank is a KondutoBankOriginAccount, delegate to the specific adapter for additional fields
        if(bank.getClass().equals(KondutoBankOriginAccount.class)){
            KondutoBankOriginAccountAdapter originAccountAdapter = new KondutoBankOriginAccountAdapter();
            return originAccountAdapter.completeSerialization(json, (KondutoBankOriginAccount) bank);
        }

        return json;
    }
}
