package com.konduto.sdk.models;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsampaio on 31/07/14.
 */
public abstract class KondutoModel {
	protected List<String> errors = new ArrayList<String>();

	public List<String> getErrors(){
		return errors;
	}

	public abstract boolean isValid();

	protected abstract JSONObject toJSON();

	protected void isRequiredError(String field) {
		this.errors.add(field + " is required");
	}

	protected void isInvalidError(String field) {
		this.errors.add(field + " is invalid");
	}

}
