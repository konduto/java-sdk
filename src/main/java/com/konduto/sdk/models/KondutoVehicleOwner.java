package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;

/**
 * KondutoVehicleOwner model, a model associated with KondutoVehicle, required by default.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoVehicleOwner extends KondutoModel {
    @Required
    private String taxId;

    private String name;

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoVehicleOwner with(String attributeName, Object attributeValue) {
        return (KondutoVehicleOwner) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        KondutoVehicleOwner anotherVehicleOwner = (KondutoVehicleOwner) obj;

        return (anotherVehicleOwner.taxId != null && taxId != null) && anotherVehicleOwner.taxId.equals(taxId);
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
