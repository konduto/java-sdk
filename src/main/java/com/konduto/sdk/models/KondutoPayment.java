package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;

/**
 * Created by rsampaio on 06/08/14.
 */
public class KondutoPayment extends KondutoModel {

	@Required private KondutoPaymentStatus paymentStatus;
	@Required private KondutoPaymentType paymentType;

	@Override
	public JSONObject toJSON() throws KondutoInvalidEntityException {
		return null;
	}
}
