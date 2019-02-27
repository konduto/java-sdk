package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoOptionFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 */
public class KondutoOptionTest {
	@Test
	public void serializeTest(){
		KondutoOption option = KondutoOptionFactory.getOption();
		JsonObject optionJSON = (JsonObject) TestUtils.readJSONFromFile("option.json");

		try {
			assertEquals("serialization failed", optionJSON, option.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("device should be valid");
		}

		KondutoOption deserializedOption = (KondutoOption) KondutoModel.fromJSON(optionJSON, KondutoOption.class);

		assertEquals("deserialization failed", deserializedOption, option);
	}
}
