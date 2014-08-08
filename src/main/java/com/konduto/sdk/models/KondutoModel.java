package com.konduto.sdk.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.konduto.sdk.adapters.KondutoPaymentAdapter;
import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * This is the parent of all models.
 *
 */
public abstract class KondutoModel {
	protected KondutoModel(){ }

	@Override
	public abstract boolean equals(Object obj);

	/* Transient and static attributes won't be included in serialization */
	protected static Gson gson = new GsonBuilder()
			.registerTypeAdapter(KondutoPayment.class, new KondutoPaymentAdapter())
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();

	protected transient List<String> errors = new ArrayList<>();

	/* Serialization methods */

	/**
	 * Serializes a model instance to JSON.
	 * @return a {@link com.google.gson.JsonObject}
	 * @throws KondutoInvalidEntityException
	 */
	public JsonObject toJSON() throws KondutoInvalidEntityException{
		if(!this.isValid()) { throw new KondutoInvalidEntityException(this); }
		return (JsonObject) gson.toJsonTree(this);
	}

	/**
	 * Converts a {@link com.google.gson.JsonObject} to a model instance.
	 * @param json the serialized instance
	 * @param klass the instance class
	 * @return an instance of KondutoModel (e.g a KondutoAddress if klass is {@code KondutoAddress.class})
	 */
	public static KondutoModel fromJSON(JsonObject json, Class<?> klass){
		return (KondutoModel) gson.fromJson(json, klass);
	}

	/* Error printing methods */

	/**
	 * @return {@link com.konduto.sdk.models.KondutoModel#errors errors} pretty printed.
	 */
	public String getErrors(){
		StringBuilder errors = new StringBuilder();
		for(String error : this.errors) {
			errors.append("\n");
			errors.append(error);
		}
		return this.getClass().getSimpleName() + errors.toString();
	}

	/**
	 * Adds a 'is required' message to {@link com.konduto.sdk.models.KondutoModel#errors errors}
	 *
	 * @param field the incorrect field
	 * @param value the incorrect field value
	 */
	void addIsRequiredError(Field field, Object value) {
		if(value != null) {
			this.errors.add("" +
					"\t" +
					field.getName() + " of class " +
					value.getClass().getSimpleName() +
					" is required but came " +
					'\'' + value + '\'');
		} else {
			this.errors.add("\t" + field.getName() + " is required but came null");
		}

	}

	/**
	 *
	 * @param errors a String containing a
	 * {@link com.konduto.sdk.models.KondutoModel#errors KondutoModel instance errors}
	 */
	void addIsInvalidError(String errors) {
		this.errors.add(errors);
	}

	/**
	 * @return whether this KondutoModel instance is valid or not.
	 */
	/* Validation method */
	public boolean isValid() {
		errors.clear();
		Object value;
		for(Field f : this.getClass().getDeclaredFields()) {
			if (!f.isSynthetic()) {
				try {
					f.setAccessible(true);
					value = f.get(this);

					// validates requirement
					if(f.isAnnotationPresent(Required.class)){
						if(value == null) {
							addIsRequiredError(f, null);
						} else {
							Method isEmptyMethod = value.getClass().getMethod("isEmpty");
							boolean isEmpty = (boolean) isEmptyMethod.invoke(value);
							if(isEmpty) {
								addIsRequiredError(f, value);
							}
						}
					}

					// if the field is a KondutoModel, check if it is valid
					if (value instanceof KondutoModel) {
						if(!((KondutoModel) value).isValid()) {
							addIsInvalidError(((KondutoModel) value).getErrors());
						}
					}
				} catch (NoSuchMethodException e) {
					// no problem if method does not exist;
				} catch (IllegalAccessException e) {
					throw new RuntimeException("Illegal access to a required field should never happen.");
				} catch (InvocationTargetException e) {
					throw new RuntimeException();
				}
			}
		}

		return errors.isEmpty();

	}
}
