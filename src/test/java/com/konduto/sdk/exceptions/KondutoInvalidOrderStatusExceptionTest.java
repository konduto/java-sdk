package com.konduto.sdk.exceptions;

import com.konduto.sdk.models.KondutoOrderStatus;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsampaio on 05/08/14.
 */
public class KondutoInvalidOrderStatusExceptionTest {
	private static final List ALLOWED_STATUS = Arrays.asList(
			KondutoOrderStatus.APPROVED,
			KondutoOrderStatus.DECLINED,
			KondutoOrderStatus.FRAUD
	);

	@Test
	public void getMessageTest() {
		KondutoInvalidOrderStatusException exception = new KondutoInvalidOrderStatusException(KondutoOrderStatus.NOT_ANALYZED);
		String expectedMessage = String.format("Status must be one of: %s, but was %s", ALLOWED_STATUS.toString() , KondutoOrderStatus.NOT_ANALYZED);
		assertEquals("expected message does not match exception message", expectedMessage, exception.getMessage());
	}

}
