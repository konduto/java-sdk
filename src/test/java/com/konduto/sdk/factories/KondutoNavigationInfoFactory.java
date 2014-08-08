package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoNavigationInfo;

/**
 * Created by rsampaio on 08/08/14.
 */
public class KondutoNavigationInfoFactory {
	public static KondutoNavigationInfo getNavigationInfo(){
		KondutoNavigationInfo navigationInfo = new KondutoNavigationInfo();
		navigationInfo.setSessionTime(12d);
		navigationInfo.setReferrer("http://www.google.com?q=buy+shirt");
		navigationInfo.setTimeSinceLastSale(4d);

		navigationInfo.setTimeOnSiteToday(26d);
		navigationInfo.setAccountsCreatedToday(2);
		navigationInfo.setPasswordResetsToday(0);
		navigationInfo.setSalesDeclinedToday(1);
		navigationInfo.setSessionsToday(4);

		navigationInfo.setTimeOnSiteSinceLastWeek(58d);
		navigationInfo.setTimePerPageSinceLastWeek(7d);
		navigationInfo.setAccountsCreatedSinceLastWeek(9);
		navigationInfo.setPasswordResetsSinceLastWeek(3);
		navigationInfo.setCheckoutPageViewsSinceLastWeek(4);
		navigationInfo.setSalesDeclinedSinceLastWeek(5);
		navigationInfo.setSessionsSinceLastWeek(12);

		navigationInfo.setTimeSinceLastSale(4d);

		return navigationInfo;
	}

}
