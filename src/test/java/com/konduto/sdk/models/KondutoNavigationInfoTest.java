package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoNavigationInfoFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 */
public class KondutoNavigationInfoTest {

	@Test
	public void serializationTest(){
		KondutoNavigationInfo navigationInfo = KondutoNavigationInfoFactory.getNavigationInfo();
		JsonObject navigationInfoJSON = (JsonObject) TestUtils.readJSONFromFile("navigation.json");
		try {
			assertEquals("serialization failed", navigationInfoJSON ,navigationInfo.toJSON());
		} catch (KondutoInvalidEntityException e) {
			fail("navigation info should be valid");
		}

		KondutoNavigationInfo navigationInfoDeserialized =
				(KondutoNavigationInfo) KondutoModel.fromJSON(navigationInfoJSON, KondutoNavigationInfo.class);

		assertEquals("deserialization failed", navigationInfoDeserialized, navigationInfo);

	}
}
