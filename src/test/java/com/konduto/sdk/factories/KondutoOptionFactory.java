package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoOption;
import com.konduto.sdk.models.KondutoSalesChannel;

/**
 * Created by andre on 21/11/16.
 */
public class KondutoOptionFactory {

    public static KondutoOption getOption(){
        KondutoOption option = new KondutoOption();
        option.setRealTime(false);
        option.setSalesChannel(KondutoSalesChannel.IVR);
        return option;
    }
}
