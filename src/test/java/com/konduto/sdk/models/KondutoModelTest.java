package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 */
public class KondutoModelTest {

	private class KondutoDummyModel extends KondutoModel {

		public KondutoDummyModel(){}

		@Required
		private String dummyField = "";

		@SuppressWarnings("unused")
		private KondutoDummyModelInternalModel internal = new KondutoDummyModelInternalModel();

		@Override
		public boolean equals(Object obj) {
			return true;
		}

		private class KondutoDummyModelInternalModel extends KondutoModel {
			@Required
			private String internalModelDummyField;

			@Override
			public boolean equals(Object obj) {
				return true;
			}
		}
	}

	KondutoDummyModel dummyModel = new KondutoDummyModel();

	@Test
	public void isRequiredErrorTest(){
		try {
			Field f = dummyModel.getClass().getDeclaredField("dummyField");
			f.setAccessible(true);
			dummyModel.addIsRequiredError(f, f.get(dummyModel));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			fail("field must exist and be accessible");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			fail("field must exist and be accessible");
		}
		assertEquals("errors should contain one error", dummyModel.errors.size(), 1);
		assertEquals("[\tdummyField of class String is required but came '']", dummyModel.errors.toString());
		dummyModel.errors.clear();
	}

	@Test
	public void isValidTest(){
		assertFalse(dummyModel.isValid());
		assertEquals(
				"KondutoDummyModel\n" +
				"\tdummyField of class String is required but came ''\n" +
				"KondutoDummyModelInternalModel\n" +
				"\tinternalModelDummyField is required but came null", dummyModel.getErrors());
	}

	@Test
	public void hashMapFactoryTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Raphael");
		map.put("email", "raphael@konduto.com");
		map.put("id", "1234");

		KondutoCustomer c = (KondutoCustomer) KondutoModel.fromMap(map, KondutoCustomer.class);

		assertEquals("map constructor did not work", "Raphael", c.getName());
		assertEquals("map constructor did not work", "raphael@konduto.com", c.getEmail());
		assertEquals("map constructor did not work", "1234", c.getId());
	}

	@Test
	public void fluentTest() {
		KondutoCustomer c = new KondutoCustomer()
				.with("name", "Raphael")
				.with("email", "raphael@konduto.com")
				.with("id", "1234");

		assertEquals("fluent constructor did not work", "Raphael", c.getName());
		assertEquals("fluent constructor did not work", "raphael@konduto.com", c.getEmail());
		assertEquals("fluent constructor did not work", "1234", c.getId());
	}

	@Test
	public void AgentTest() {
		KondutoAgentSeller c = new KondutoAgentSeller()
				.with("name", "Igor F Rodrigues")
				.with("login", "igor.rodrigues")
				.with("id", "1234");

		assertEquals("Agent constructor did not work", "Igor F Rodrigues", c.getName());
		assertEquals("Agent constructor did not work", "igor.rodrigues", c.getLogin());
		assertEquals("Agent constructor did not work", "1234", c.getId());
	}

}
