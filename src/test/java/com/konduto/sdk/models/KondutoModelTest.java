package com.konduto.sdk.models;

import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoModelTest {

	private class KondutoDummyModel extends KondutoModel{

		@Override
		public boolean isValid() {
			return false;
		}

		@Override
		protected JSONObject toJSON() {
			return null;
		}
	}

	KondutoDummyModel dummyModel = new KondutoDummyModel();

	@Test
	public void isRequiredErrorTest(){
		dummyModel.isRequiredError("dummy field");
		assertEquals("errors should contain one error", dummyModel.errors.size(), 1);
		assertTrue("errors should be [\"dummy field is required\"]", dummyModel.errors.get(0).equalsIgnoreCase("dummy field is required"));
		dummyModel.errors.clear();
	}

}
