package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoTriggeredDecisionListTest {
    @Test
    public void deserializeTest() {
        JsonObject triggeredDecisionListAsJson = new JsonObject();
        triggeredDecisionListAsJson.addProperty("type", "zip");
        triggeredDecisionListAsJson.addProperty("trigger", "shipping_zip");
        triggeredDecisionListAsJson.addProperty("decision", "review");
        KondutoTriggeredDecisionList triggeredDecisionList =
                (KondutoTriggeredDecisionList) KondutoModel.fromJSON(
                        triggeredDecisionListAsJson, KondutoTriggeredDecisionList.class);
        assertEquals(KondutoDecisionListType.ZIP, triggeredDecisionList.getType());
        assertEquals(KondutoDecisionListTrigger.SHIPPING_ZIP, triggeredDecisionList.getTrigger());
        assertEquals(KondutoRecommendation.REVIEW, triggeredDecisionList.getDecision());
    }
}
