package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoSeller;

import java.util.Date;

public class KondutoSellerFactory {

    public static KondutoSeller getKondutoSeller(){
        KondutoSeller seller = new KondutoSeller();
        seller.setId("seller_id");
        seller.setName("Seller Name");
        seller.setCreated_at(new Date(1433818800000L));
        return seller;
    }
}
