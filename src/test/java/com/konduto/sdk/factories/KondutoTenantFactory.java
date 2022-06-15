package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoTenant;

import java.util.Date;

public class KondutoTenantFactory {

    public static KondutoTenant getKondutoTenant(){
        KondutoTenant tenant = new KondutoTenant();
        tenant.setId("seller_id");
        tenant.setName("Seller Name");
        tenant.setCreatedAt(new Date(1433818800000L));
        return tenant;
    }
}
