package com.konduto.sdk.exceptions;

import com.konduto.sdk.models.KondutoModel;

/**
 * Created by rsampaio on 31/07/14.
 */
public final class KondutoInvalidEntityException extends KondutoException {
	private KondutoModel entity;

	public KondutoInvalidEntityException(KondutoModel entity) {
		this.entity = entity;
	}

	@Override
	public String getMessage() {
		return String.format("%s is invalid: %s", this.entity, this.entity.getErrors());
	}
}
