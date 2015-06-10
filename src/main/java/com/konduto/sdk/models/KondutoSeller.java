package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

import java.util.Date;

/**
 *
 * Seller model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public final class KondutoSeller extends KondutoModel {

	/* Attributes */

    @Required private String id = "1";
    @Required private String name;
    private Date created_at;

	/* Constructors */

    public KondutoSeller() { }

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoCustomer with(String attributeName, Object attributeValue) {
        return (KondutoCustomer) super.with(attributeName, attributeValue);
    }

	/* Equals */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KondutoSeller)) return false;

        KondutoSeller that = (KondutoSeller) o;

        // required
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;

        // optional
        if (!nullSafeAreDatesEqual(created_at, that.created_at)){
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

    public Date getCreated_at() { return created_at; }

    public void setCreated_at(Date created_at) { this.created_at = created_at; }
}
