package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsampaio on 31/07/14.
 */
public abstract class KondutoModel {
	protected List<String> errors = new ArrayList<>();

	public String getErrors(){
		StringBuilder errors = new StringBuilder();
		for(String error : this.errors) {
			errors.append("\n");
			errors.append(error);
		}
		return this.getClass().getSimpleName() + errors.toString();
	}

	public abstract JSONObject toJSON() throws KondutoInvalidEntityException;

	void addIsRequiredError(Field field, Object value) {
		if(value != null) {
			this.errors.add("" +
					"\t- " +
					field.getName() + " of class " +
					value.getClass().getSimpleName() +
					" is required but came " +
					'\'' + value + '\'');
		} else {
			this.errors.add("\t- " + field.getName() + " is required but came null");
		}

	}

	void addIsInvalidError(String errors) {
		this.errors.add(errors);
	}

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
