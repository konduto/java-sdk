package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Bureau query model for credit bureau information.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoBureauQuery extends KondutoModel {
    @SerializedName("service")
    private String kondutoBureauService;
    @SerializedName("response")
    private Map<String, Object> kondutoBureauResponse;

    /**
     * Default constructor.
     */
    public KondutoBureauQuery() {
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof KondutoBureauQuery)) { return false; }
        KondutoBureauQuery that = (KondutoBureauQuery) obj;
        return this.kondutoBureauService == that.kondutoBureauService &&
                this.kondutoBureauResponse.equals(that.kondutoBureauResponse);
    }

    /**
     * Gets the bureau service name.
     *
     * @return the bureau service name
     */
    public String getService() {
        return kondutoBureauService;
    }

    /**
     * Sets the bureau service name.
     *
     * @param kondutoBureauService the bureau service name
     */
    public void setService(String kondutoBureauService) {
        this.kondutoBureauService = kondutoBureauService;
    }

    /**
     * Gets the bureau response data.
     *
     * @return the bureau response map
     */
    public Map<String, Object> getResponse() {
        return kondutoBureauResponse;
    }

    /**
     * Sets the bureau response data.
     *
     * @param kondutoBureauResponse the bureau response map
     */
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
    public Object getAttribute(String field) {
        if(field == null || this.kondutoBureauResponse == null) { return null; }
        return this.kondutoBureauResponse.get(field);
    }

    /**
     * Sets an attribute in the bureau response.
     *
     * @param key the attribute key
     * @param value the attribute value
     */
    public void setAttribute(String key, Object value) {
        if(this.kondutoBureauResponse == null) {
            this.kondutoBureauResponse = new HashMap<String, Object>();
        }
        this.kondutoBureauResponse.put(key, value);
    }
}
