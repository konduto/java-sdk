package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by rsampaio on 31/07/14.
 */
public class KondutoModelTest {

	private class KondutoDummyModel extends KondutoModel{
		@Required
		private String dummyField = "";

		private KondutoDummyModelInternalModel internal = new KondutoDummyModelInternalModel();

		private class KondutoDummyModelInternalModel extends KondutoModel {
			@Required
			private String internalModelDummyField;

			@Override
			public JSONObject toJSON() throws KondutoInvalidEntityException {
				return null;
			}
		}

		@Override
		public JSONObject toJSON() {
			return null;
		}

		public String getDummyField() {
			return dummyField;
		}

		public void setDummyField(String dummyField) {
			this.dummyField = dummyField;
		}
	}

	KondutoDummyModel dummyModel = new KondutoDummyModel();

	@Test
	public void isRequiredErrorTest(){
		try {
			Field f = dummyModel.getClass().getDeclaredField("dummyField");
			f.setAccessible(true);
			dummyModel.addIsRequiredError(f, f.get(dummyModel));
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			fail("field must exist and be accessible");
		}
		assertEquals("errors should contain one error", dummyModel.errors.size(), 1);
		assertEquals("[\t- dummyField of class String is required but came '']", dummyModel.errors.toString());
		dummyModel.errors.clear();
	}

	@Test
	public void isValidTest(){
		assertFalse(dummyModel.isValid());
		assertEquals(
				"KondutoDummyModel\n" +
				"\t- dummyField of class String is required but came ''\n" +
				"KondutoDummyModelInternalModel\n" +
				"\t- internalModelDummyField is required but came null", dummyModel.getErrors());
	}

}
