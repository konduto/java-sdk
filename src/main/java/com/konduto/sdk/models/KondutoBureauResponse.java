package com.konduto.sdk.models;

public class KondutoBureauResponse extends KondutoModel {
    private KondutoBureauResponseField key;
    private Object value;

    private void setValue(Object value) {
        this.value = value;
    }

    private Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        KondutoBureauResponse that = (KondutoBureauResponse) obj;
        return this.key == that.key ||
                (this.getValue() != null && this.getValue().equals(that.getValue()));
    }

    public void setKey(KondutoBureauResponseField key) {
        this.key = key;
    }
}
