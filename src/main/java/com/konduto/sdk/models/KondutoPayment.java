package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 * Created by rsampaio on 06/08/14.
 */
public class KondutoPayment extends KondutoModel {

	/* Attributes */
	@Required private KondutoPaymentStatus status;
	@Required private KondutoPaymentType type;

	/* Constructors */

	/* Equals */

	/* Getters and Setters */


}
