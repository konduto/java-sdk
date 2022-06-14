package com.konduto.sdk.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konduto.sdk.models.KondutoBankDestinationAccount;
import com.konduto.sdk.models.KondutoBankDocumentType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 10/06/2022.
 */
public class KondutoBankDestinationAccountAdapter extends KondutoBankAdapter implements JsonSerializer<KondutoBankDestinationAccount>, JsonDeserializer<Collection<KondutoBankDestinationAccount>> {

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
    public Collection<KondutoBankDestinationAccount> deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Collection<KondutoBankDestinationAccount> destinationAccounts = new ArrayList<KondutoBankDestinationAccount>();
        for (JsonElement jsonElement : je.getAsJsonArray()) {
            JsonObject json = (JsonObject) jsonElement;

            KondutoBankDestinationAccount account = setDeserialize(json, context);
            if (json.has("id")) {
                account.setId(json.get("id").getAsString());
            }
            if (json.has("key_type")) {
                account.setKeyType(KondutoBankDocumentType.valueOf(json.get("key_type").getAsString().toUpperCase()));
            }
            if (json.has("key_value")) {
                account.setKeyValue(json.get("key_value").getAsString());
            }
            if (json.has("holder_name")) {
                account.setHolderName(json.get("holder_name").getAsString());
            }
            if (json.has("holder_tax_id")) {
                account .setHolderTaxId(json.get("holder_tax_id").getAsString());
            }
            if (json.has("bank_code")) {
                account .setBankCode(json.get("bank_code").getAsString());
            }
            if (json.has("bank_name")) {
                account .setBankName(json.get("bank_name").getAsString());
            }
            if (json.has("bank_branch")) {
                account .setBankBranch(json.get("bank_branch").getAsString());
            }
            if (json.has("bank_account")) {
                account .setBankAccount(json.get("bank_account").getAsString());
            }
            if (json.has("amount")) {
                account .setAmount(json.get("amount").getAsDouble());
            }
            destinationAccounts.add(account);
        }
        return destinationAccounts;
    }

    public KondutoBankDestinationAccount setDeserialize(JsonObject je,
                                      JsonDeserializationContext context) {
        return context.deserialize(je, KondutoBankDestinationAccount.class);
    }

    /**
     * Gson invokes this call-back method during serialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonSerializationContext#serialize(Object, Type)} method to create JsonElements for any
     * non-trivial field of the {@code src} object. However, you should never invoke it on the
     * {@code src} object itself since that will cause an infinite loop (Gson will call your
     * call-back method again).</p>
     *
     * @param destinationAccount the object that needs to be converted to Json.
     * @param typeOfSrc          the actual type (fully genericized version) of the source object.
     * @param context
     * @return a JsonElement corresponding to the specified object.
     */
    @Override
    public JsonElement serialize(KondutoBankDestinationAccount destinationAccount, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = (JsonObject) super.serialize(destinationAccount);

        if (destinationAccount.getId() != null) {
            json.addProperty("id", destinationAccount.getId());
        }
        if (destinationAccount.getKeyType() != null) {
            json.addProperty("key_type", destinationAccount.getKeyType().toString().toLowerCase());
        }
        if (destinationAccount.getKeyValue() != null) {
            json.addProperty("key_value", destinationAccount.getKeyValue());
        }
        if (destinationAccount.getHolderName() != null) {
            json.addProperty("holder_name", destinationAccount.getHolderName());
        }
        if (destinationAccount.getHolderTaxId() != null) {
            json.addProperty("holder_tax_id", destinationAccount.getHolderTaxId());
        }
        if (destinationAccount.getBankCode() != null) {
            json.addProperty("bank_code", destinationAccount.getBankCode());
        }
        if (destinationAccount.getBankName() != null) {
            json.addProperty("bank_name", destinationAccount.getBankName());
        }
        if (destinationAccount.getBankBranch() != null) {
            json.addProperty("bank_branch", destinationAccount.getBankBranch());
        }
        if (destinationAccount.getBankAccount() != null) {
            json.addProperty("bank_account", destinationAccount.getBankAccount());
        }
        if (destinationAccount.getAmount() != null) {
            json.addProperty("amount", destinationAccount.getAmount());
        }

        return json;
    }

}
