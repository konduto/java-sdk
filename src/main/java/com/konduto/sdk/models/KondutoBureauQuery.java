package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class KondutoBureauQuery extends KondutoModel {
    @SerializedName("service")
    private KondutoBureauService kondutoBureauService;
    @SerializedName("response")
    private Map<String, Object> kondutoBureauResponse;

    @Override
    public boolean equals(Object obj) {
        KondutoBureauQuery that = (KondutoBureauQuery) obj;
        return this.kondutoBureauService == that.kondutoBureauService &&
                this.kondutoBureauResponse.equals(that.kondutoBureauResponse);
    }

    public KondutoBureauService getService() {
        return kondutoBureauService;
    }

    public void setService(KondutoBureauService kondutoBureauService) {
        this.kondutoBureauService = kondutoBureauService;
    }

    public Map<String, Object> getResponse() {
        return kondutoBureauResponse;
    }

    public void setResponse(Map<String, Object> kondutoBureauResponse) {
        this.kondutoBureauResponse = kondutoBureauResponse;
    }
}
