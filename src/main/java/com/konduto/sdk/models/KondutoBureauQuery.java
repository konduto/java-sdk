package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class KondutoBureauQuery extends KondutoModel {
    @SerializedName("service")
    private KondutoBureauService kondutoBureauService;
    @SerializedName("response")
    private Map<String, Object> kondutoBureauResponse;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof KondutoBureauQuery)) { return false; }
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

    /**
     * Return the value of a field in a bureau response (e.g.
     * email_domain_exists).
     *
     * @param field what field to look for
     * @return the value of that field
     */
    public Object getAttribute(KondutoBureauResponseField field) {
        if(field == null || this.kondutoBureauResponse == null) { return null; }
        return this.kondutoBureauResponse.get(field.toString().toLowerCase());
    }

    public void setAttribute(KondutoBureauResponseField key, Object value) {
        if(this.kondutoBureauResponse == null) {
            this.kondutoBureauResponse = new HashMap<String, Object>();
        }
        this.kondutoBureauResponse.put(key.toString().toLowerCase(), value);
    }
}
