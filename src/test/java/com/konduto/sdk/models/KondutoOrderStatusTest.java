package com.konduto.sdk.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rsampaio on 01/08/14.
 */
public class KondutoOrderStatusTest {
	@Test
	public void fromStringTest() {
		assertNull(KondutoOrderStatus.fromString("not a valid string"));
		assertEquals(KondutoOrderStatus.PENDING, KondutoOrderStatus.fromString("pEnDiNG"));
		assertEquals(KondutoOrderStatus.APPROVED, KondutoOrderStatus.fromString("ApPrOvEd"));
		assertEquals(KondutoOrderStatus.DECLINED, KondutoOrderStatus.fromString("declined"));
		assertEquals(KondutoOrderStatus.FRAUD, KondutoOrderStatus.fromString("fraud"));
		assertEquals(KondutoOrderStatus.NOT_ANALYZED, KondutoOrderStatus.fromString("not analyzed"));
	}
}
