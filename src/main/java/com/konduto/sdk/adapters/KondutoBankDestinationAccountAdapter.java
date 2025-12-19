package com.konduto.sdk.adapters;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
 * Adapter for serializing and deserializing collections of KondutoBankDestinationAccount objects.
 */
public class KondutoBankDestinationAccountAdapter implements JsonSerializer<Collection<KondutoBankDestinationAccount>>, JsonDeserializer<Collection<KondutoBankDestinationAccount>> {

    /**
     * Default constructor.
     */
    public KondutoBankDestinationAccountAdapter() {
    }

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
     * @param context The context for deserialization
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
                account.setHolderTaxId(json.get("holder_tax_id").getAsString());
            }
            if (json.has("bank_code")) {
                account.setBankCode(json.get("bank_code").getAsString());
            }
            if (json.has("bank_name")) {
                account.setBankName(json.get("bank_name").getAsString());
            }
            if (json.has("bank_branch")) {
                account.setBankBranch(json.get("bank_branch").getAsString());
            }
            if (json.has("bank_account")) {
                account.setBankAccount(json.get("bank_account").getAsString());
            }
            if (json.has("amount")) {
                account.setAmount(json.get("amount").getAsDouble());
            }
            destinationAccounts.add(account);
        }
        return destinationAccounts;
    }

    /**
     * Helper method to deserialize a single KondutoBankDestinationAccount from JSON.
     *
     * @param je the JSON object to deserialize
     * @param context the deserialization context
     * @return the deserialized KondutoBankDestinationAccount
     */
    public KondutoBankDestinationAccount setDeserialize(JsonObject je,
                                                        JsonDeserializationContext context) {
        return context.deserialize(je, KondutoBankDestinationAccount.class);
    }

    @Override
    public JsonElement serialize(Collection<KondutoBankDestinationAccount> src, Type typeOfSrc, JsonSerializationContext context) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(typeOfSrc, new KondutoBankDestinationAccountAdapter())
                .create();

        return gson.toJsonTree(src);
    }

}
