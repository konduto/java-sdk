package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 * Created by rsampaio on 06/08/14.
 */
public abstract class KondutoPayment extends KondutoModel {

	/* Attributes */
	@Required
	public KondutoPaymentType type;


	/* Constructors */

	/* Equals */

	/* Getters and Setters */

	public KondutoPaymentType getType(){
		return this.type;
	}


	@Override
	public abstract boolean equals(Object obj);

}
