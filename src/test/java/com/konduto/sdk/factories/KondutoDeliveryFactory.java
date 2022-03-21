package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoDelivery;

public class KondutoDeliveryFactory {
    public static KondutoDelivery getDelivery() {
        KondutoDelivery delivery = new KondutoDelivery();
        delivery.setDeliveryCompany("GFL");
        delivery.setDeliveryMethod("retira_loja");
        delivery.setEstimatedDeliveryDate("2021-05-06");
        delivery.setEstimatedShippingDate("2021-05-06");
        return delivery;
    }
}
