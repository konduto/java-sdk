package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoTriggeredRuleTest {
    @Test
    public void deserializeTest() {
        JsonObject triggeredRuleAsJson = new JsonObject();
        triggeredRuleAsJson.addProperty("name", "Triggered");
        triggeredRuleAsJson.addProperty("decision", "decline");
        KondutoTriggeredRule triggeredRule =
                (KondutoTriggeredRule) KondutoModel.fromJSON(
                        triggeredRuleAsJson, KondutoTriggeredRule.class);
        assertEquals("Triggered", triggeredRule.getName());
        assertEquals(KondutoRecommendation.DECLINE, triggeredRule.getDecision());
    }
}
