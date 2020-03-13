package com.konduto.sdk.models;

import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;

/**
 * KondutoVehicle model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoVehicle extends KondutoModel {
    @Required
    private KondutoVehicleOwner owner;

    @Required
    private String make;

    @Required
    private String model;

    @ValidateFormat(format = "[a-zA-Z0-9]{11}")
    private String renavam;

    private String registration;

    @ValidateFormat(format = "[a-zA-Z0-9]{17}")
    private String vid;

    private KondutoVehicleType type;

    private KondutoVehicleUsage usage;

    /**
     * Fluent constructor
     * @param attributeName the attribute name (e.g totalAmount)
     * @param attributeValue the attribute value (e.g 123.2)
     * @return a new instance
     */
    @Override
    public KondutoVehicle with(String attributeName, Object attributeValue) {
        return (KondutoVehicle) super.with(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        KondutoVehicle anotherVehicle = (KondutoVehicle) obj;

        if (anotherVehicle.registration == null || registration == null
                || !anotherVehicle.registration.equals(registration)) return false;

        if (anotherVehicle.renavam == null || renavam == null
                || !anotherVehicle.renavam.equals(renavam)) return false;

        return anotherVehicle.vid != null && vid != null
                && anotherVehicle.vid.equals(vid);
    }

    @Override
    public boolean isValid() {
        return super.isValid() && owner.isValid();
    }

    public KondutoVehicleOwner getOwner() {
        return owner;
    }

    public void setOwner(KondutoVehicleOwner owner) {
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public KondutoVehicleType getType() {
        return type;
    }

    public void setType(KondutoVehicleType type) {
        this.type = type;
    }

    public KondutoVehicleUsage getUsage() {
        return usage;
    }

    public void setUsage(KondutoVehicleUsage usage) {
        this.usage = usage;
    }

}
