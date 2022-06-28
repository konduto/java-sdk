package com.konduto.sdk.factories;

import com.konduto.sdk.DateFormat;
import com.konduto.sdk.models.KondutoTenant;

import java.util.Date;

import static com.konduto.sdk.utils.TestUtils.getDateFrom;

public class KondutoTenantFactory {

    public static KondutoTenant getKondutoTenant(){
        KondutoTenant tenant = new KondutoTenant();
        tenant.setId("0001");
        tenant.setName("TikPay");
        tenant.setCreatedAt(getDateFrom("2014-12-31T13:00:00Z", DateFormat.ISO_DATETIME));
        return tenant;
    }
}
