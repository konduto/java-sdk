package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoAgentSellerFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 03/06/2022.
 */
public class KondutoAgentSellerTest {

	@Test
	public void isValidTest() {
		KondutoAgentSeller agent = new KondutoAgentSeller();
		assertFalse("Agent should be invalid without id", agent.isValid());
		agent.setId("1");
		assertFalse("Agent should be invalid without name", agent.isValid());
		agent.setName("Igor");;
		assertTrue("Agent Seller should be valid", agent.isValid());
	}

	@Test
	public void serializationTest() throws ParseException {
		KondutoAgentSeller agentSeller = KondutoAgentSellerFactory.getAgentSeller();
		JsonObject agentJSON = (JsonObject) TestUtils.readJSONFromFile("agent.json");
		try {
			assertEquals("serialization failed", agentJSON, agentSeller.toJSON());
		} catch (KondutoInvalidEntityException e) {
			e.printStackTrace();
		}

		KondutoAgentSeller deserializedAgent = (KondutoAgentSeller)
				KondutoModel.fromJSON(agentJSON, KondutoAgentSeller.class);

		assertEquals("deserialization failed", agentSeller, deserializedAgent);

	}

	@Test(expected=KondutoInvalidEntityException.class)
	public void invalidAgentSellerSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
		KondutoAgentSeller agentSeller = new KondutoAgentSeller();
		agentSeller.toJSON(); // triggers invalid customer exception
	}
}
