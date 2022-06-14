package com.konduto.sdk.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.konduto.sdk.models.KondutoBankDocumentType;
import com.konduto.sdk.models.KondutoBankOriginAccount;

import java.lang.reflect.Type;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 09/06/2022.
 */
public class KondutoBankOriginAccountAdapter extends KondutoBankAdapter implements JsonDeserializer<KondutoBankOriginAccount> {

    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
     * for any non-trivial field of the returned object. However, you should never invoke it on the
     * the same type passing {@code json} since that will cause an infinite loop (Gson will call your
     * call-back method again).
     *
     * @param je      The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context
     * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     */
    @Override
    public KondutoBankOriginAccount deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = (JsonObject) je;

        KondutoBankOriginAccount originAccount = new KondutoBankOriginAccount();

        if (json.has("id")) {
            originAccount.setId(json.get("id").getAsString());
        }
        if (json.has("key_type")) {
            originAccount.setKeyType(KondutoBankDocumentType.valueOf(json.get("key_type").getAsString().toUpperCase()));
        }
        if (json.has("key_value")) {
            originAccount.setKeyValue(json.get("key_value").getAsString());
        }
        if (json.has("holder_name")) {
            originAccount.setHolderName(json.get("holder_name").getAsString());
        }
        if (json.has("holder_tax_id")) {
            originAccount.setHolderTaxId(json.get("holder_tax_id").getAsString());
        }
        if (json.has("bank_code")) {
            originAccount.setBankCode(json.get("bank_code").getAsString());
        }
        if (json.has("bank_name")) {
            originAccount.setBankName(json.get("bank_name").getAsString());
        }
        if (json.has("bank_branch")) {
            originAccount.setBankBranch(json.get("bank_branch").getAsString());
        }
        if (json.has("bank_account")) {
            originAccount.setBankAccount(json.get("bank_account").getAsString());
        }
        if (json.has("balance")) {
            originAccount.setBalance(json.get("balance").getAsDouble());
        }

        return originAccount;
    }


    public JsonElement completeSerialization(JsonObject json, KondutoBankOriginAccount originAccount){

        if (originAccount.getBalance() != null) {
            json.addProperty("balance", originAccount.getBalance());
        }

        return json;
    }

}
