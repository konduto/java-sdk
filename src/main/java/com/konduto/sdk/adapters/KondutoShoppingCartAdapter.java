package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.KondutoItem;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rsampaio on 11/08/14.
 *
 * Shopping cart (collection of KondutoItem), serialization/deserialization.
 *
 */
public class KondutoShoppingCartAdapter
		implements JsonSerializer<Collection<KondutoItem>>, JsonDeserializer<Collection<KondutoItem>> {


	@Override
	public Collection<KondutoItem> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		Collection<KondutoItem> shoppingCart = new ArrayList<KondutoItem>();

		for(JsonElement je : json.getAsJsonArray()) {
			shoppingCart.add((KondutoItem) context.deserialize(je, KondutoItem.class));
		}
		return shoppingCart;
	}

	@Override
	public JsonElement serialize(Collection<KondutoItem> shoppingCart, Type typeOfSrc, JsonSerializationContext context) {
		JsonArray json = new JsonArray();

		for(KondutoItem item : shoppingCart) {
			json.add(context.serialize(item));
		}

		return json;
	}
}
