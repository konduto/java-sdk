package com.konduto.sdk.exceptions;

import com.konduto.sdk.models.KondutoOrderStatus;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rsampaio on 05/08/14.
 */
public class KondutoInvalidOrderStatusException extends KondutoException {
	private KondutoOrderStatus status;

	private static final List ALLOWED_STATUS = Arrays.asList(
			KondutoOrderStatus.APPROVED,
			KondutoOrderStatus.DECLINED,
			KondutoOrderStatus.FRAUD
	);

	public KondutoInvalidOrderStatusException(KondutoOrderStatus status){
		this.status = status;
	}

	@Override
	public String getMessage() {
		return String.format("Status must be one of: %s, but was %s", ALLOWED_STATUS.toString() , this.status);
	}
}
