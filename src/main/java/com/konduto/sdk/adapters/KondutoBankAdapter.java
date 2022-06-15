package com.konduto.sdk.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konduto.sdk.models.KondutoBank;
import com.konduto.sdk.models.KondutoBankDestinationAccount;
import com.konduto.sdk.models.KondutoBankOriginAccount;

import java.lang.reflect.Type;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 09/06/2022.
 * KondutoBanKAdapter to deserialize KondutoBank objects.
 */
public class KondutoBankAdapter implements JsonSerializer<KondutoBank> {

    @Override
    public JsonElement serialize(KondutoBank bank, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
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
//        if(bank.getClass().equals(KondutoBankDestinationAccount.class)){
//            KondutoBankDestinationAccountAdapter destinationAccountAdapter = new KondutoBankDestinationAccountAdapter();
//            return destinationAccountAdapter.completeSerialization(json, (KondutoBankDestinationAccount) bank);
//        }
        if(bank.getClass().equals(KondutoBankOriginAccount.class)){
            KondutoBankOriginAccountAdapter originAccountAdapter = new KondutoBankOriginAccountAdapter();
            return originAccountAdapter.completeSerialization(json, (KondutoBankOriginAccount) bank);
        }

        return json;
    }
}
