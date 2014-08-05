package com.konduto.sdk.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by rsampaio on 01/08/14.
 */
public class KondutoRecommendationTest {
	@Test
	public void fromStringTest(){
		assertNull(KondutoRecommendation.fromString("not a valid string"));
		assertEquals(KondutoRecommendation.APPROVE, KondutoRecommendation.fromString("aPpRoVe"));
		assertEquals(KondutoRecommendation.DECLINE, KondutoRecommendation.fromString("DeClInE"));
		assertEquals(KondutoRecommendation.REVIEW, KondutoRecommendation.fromString("review"));
		assertEquals(KondutoRecommendation.NONE, KondutoRecommendation.fromString("none"));
	}

}
