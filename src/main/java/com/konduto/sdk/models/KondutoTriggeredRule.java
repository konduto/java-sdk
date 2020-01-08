package com.konduto.sdk.models;

public class KondutoTriggeredRule extends KondutoModel {
    private String name;
    private KondutoRecommendation decision;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KondutoTriggeredRule that = (KondutoTriggeredRule) o;

        if (!name.equals(that.name)) return false;
        return decision == that.decision;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + decision.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public KondutoRecommendation getDecision() {
        return decision;
    }
}
