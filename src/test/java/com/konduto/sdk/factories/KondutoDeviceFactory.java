package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoDevice;

/**
 */
public class KondutoDeviceFactory {
	public static KondutoDevice getDevice(){
		KondutoDevice device = new KondutoDevice();
		device.setBrowser("Chrome");
		device.setCookie(true);
		device.setFingerprint("e4f2c690951038a8f77aa583847");
		device.setFlash(true);
		device.setIp("170.149.100.10");
		device.setJavascript(true);
		device.setPlatform("MacIntel");
		device.setUserId("405961fab293600daeed93ae561");
		device.setLanguage("en_US");
		device.setTimezone("GMT -1");
		return device;
	}

}
