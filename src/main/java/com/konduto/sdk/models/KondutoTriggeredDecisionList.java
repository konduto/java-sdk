package com.konduto.sdk.models;

public class KondutoTriggeredDecisionList extends KondutoModel {
    private KondutoDecisionListType type;
    private KondutoDecisionListTrigger trigger;
    private KondutoRecommendation decision;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoTriggeredDecisionList that = (KondutoTriggeredDecisionList) o;

        if (type != that.type) return false;
        if (trigger != that.trigger) return false;
        return decision == that.decision;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + trigger.hashCode();
        result = 31 * result + decision.hashCode();
        return result;
    }

    public KondutoDecisionListType getType() {
        return type;
    }

    public KondutoDecisionListTrigger getTrigger() {
        return trigger;
    }

    public KondutoRecommendation getDecision() {
        return decision;
    }
}
