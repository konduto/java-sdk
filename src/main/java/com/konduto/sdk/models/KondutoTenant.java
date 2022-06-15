package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;

import java.util.Date;

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
    private String id = "1";
    @Required
    private String name;

    @SerializedName("created_at")
    private Date createdAt;

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

        // optional
        if (!nullSafeAreDatesEqual(createdAt, that.createdAt)) {
            return false;
        }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date created_at) {
        this.createdAt = created_at;
    }
}
