package com.konduto.sdk.exceptions;

import com.konduto.sdk.models.KondutoModel;

/**
 *
 * This exception is thrown when a {@link KondutoModel} instance is invalid.
 */
public final class KondutoInvalidEntityException extends KondutoException {
	
	private static final long serialVersionUID = 4627487289664092129L;
	private KondutoModel entity;

	public KondutoInvalidEntityException(KondutoModel entity) {
		this.entity = entity;
	}

	/**
	 *
	 * @return A message informing the invalid entity and reason.
	 */
	@Override
	public String getMessage() {
		return String.format("%s is invalid: %s", this.entity, this.entity.getErrors());
	}
}
