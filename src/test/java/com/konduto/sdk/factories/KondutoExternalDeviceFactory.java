package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoExternalDevice;

public class KondutoExternalDeviceFactory {
    public static KondutoExternalDevice getExternalDevice(){
        KondutoExternalDevice externalDevice = new KondutoExternalDevice();
        externalDevice.setUserId("anyID");
        externalDevice.setBrowser("Chrome");
        externalDevice.setProvider("SO");
        externalDevice.setCategory("Mobile");
        externalDevice.setModel("S10");
        externalDevice.setManufacturer("Samsung");
        externalDevice.setOs("Android 11");
        externalDevice.setFingerprint("e4f2c690951038a8f77aa583847");
        externalDevice.setPlatform("Android");
        externalDevice.setLanguage("pt");
        return externalDevice;
    }

}