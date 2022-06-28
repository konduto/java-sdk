package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.DateFormat;
import com.konduto.sdk.annotations.Required;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Tenant model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public final class KondutoTenant extends KondutoModel {

    /**
     * Attributes
     * {
     * "tenant": {
     * "id": "0001",
     * "name": "TikPay",
     * "created_at": "2020-05-16"
     * }
     * }
     */

    @Required
    private String id;
    @Required
    private String name;

    @SerializedName("created_at")
    private String createdAt; // format: yyyy-MM-ddT2018-12-25T18:00Z

    /* Constructors */

    public KondutoTenant() {
    }

    /**
     * Fluent constructor
     *
     * @param attributeName  the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoTenant with(String attributeName, Object attributeValue) {
        return (KondutoTenant) super.with(attributeName, attributeValue);
    }

    /* Equals */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KondutoTenant)) return false;

        KondutoTenant that = (KondutoTenant) o;

        // required
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    /* Getters and Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the expiration date.
     *
     * ATTENTION: must be an ISO (UTC) datetime (yyyy-MM-ddTHH:mm:ssZ)
     *
     * @param created_at ISO datetime string
     */
    public void setCreatedAt(String created_at) {
        this.createdAt = created_at;
        if(created_at == null ||
                !created_at.matches(DateFormat.ISO_DATETIME.getRegex())) {
            throw new IllegalArgumentException("Invalid datetime: " + created_at);
        }
        this.createdAt = created_at;
    }
    /**
     * Sets
     * @param created_at
     */
    public void setCreatedAt(Date created_at) {
        SimpleDateFormat sdf =
                new SimpleDateFormat(DateFormat.ISO_DATETIME.getFormat());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.createdAt = sdf.format(created_at);
    }

}
