package com.konduto.sdk.models;

import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsampaio on 31/07/14.
 */
public abstract class KondutoModel {
	protected List<String> errors = new ArrayList<String>();

	public String getErrors(){
		return errors.toString();
	}

	public abstract boolean isValid();

	public abstract JSONObject toJSON() throws KondutoInvalidEntityException;

	protected void isRequiredError(String field) {
		this.errors.add(field + " is required");
	}

	protected void isInvalidError(String field) {
		this.errors.add(field + " is invalid");
	}

}
