package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Navigation info model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoNavigationInfo extends KondutoModel {

	/* all times in minutes */

	private Double sessionTime;

	private String referrer;

	@SerializedName("time_site_1d")
	private Double timeOnSiteToday;

	@SerializedName("new_accounts_1d")
	private Integer accountsCreatedToday;

	@SerializedName("password_resets_1d")
	private Integer passwordResetsToday;

	@SerializedName("sales_declined_1d")
	private Integer salesDeclinedToday;

	@SerializedName("sessions_1d")
	private Integer sessionsToday;

	@SerializedName("time_site_7d")
	private Double timeOnSiteSinceLastWeek;

	@SerializedName("new_accounts_7d")
	private Integer accountsCreatedSinceLastWeek;

	@SerializedName("time_per_page_7d")
	private Double timePerPageSinceLastWeek;

	@SerializedName("password_resets_7d")
	private Integer passwordResetsSinceLastWeek;

	@SerializedName("checkout_count_7d")
	private Integer checkoutPageViewsSinceLastWeek;

	@SerializedName("sales_declined_7d")
	private Integer salesDeclinedSinceLastWeek;

	@SerializedName("sessions_7d")
	private Integer sessionsSinceLastWeek;

	private Double timeSinceLastSale;

	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoNavigationInfo)) return false;

		KondutoNavigationInfo that = (KondutoNavigationInfo) o;

		if (accountsCreatedSinceLastWeek != null ? !accountsCreatedSinceLastWeek.equals(that.accountsCreatedSinceLastWeek) : that.accountsCreatedSinceLastWeek != null)
			return false;
		if (accountsCreatedToday != null ? !accountsCreatedToday.equals(that.accountsCreatedToday) : that.accountsCreatedToday != null)
			return false;
		if (checkoutPageViewsSinceLastWeek != null ? !checkoutPageViewsSinceLastWeek.equals(that.checkoutPageViewsSinceLastWeek) : that.checkoutPageViewsSinceLastWeek != null)
			return false;
		if (passwordResetsSinceLastWeek != null ? !passwordResetsSinceLastWeek.equals(that.passwordResetsSinceLastWeek) : that.passwordResetsSinceLastWeek != null)
			return false;
		if (passwordResetsToday != null ? !passwordResetsToday.equals(that.passwordResetsToday) : that.passwordResetsToday != null)
			return false;
		if (referrer != null ? !referrer.equals(that.referrer) : that.referrer != null) return false;
		if (salesDeclinedSinceLastWeek != null ? !salesDeclinedSinceLastWeek.equals(that.salesDeclinedSinceLastWeek) : that.salesDeclinedSinceLastWeek != null)
			return false;
		if (salesDeclinedToday != null ? !salesDeclinedToday.equals(that.salesDeclinedToday) : that.salesDeclinedToday != null)
			return false;
		if (sessionTime != null ? !sessionTime.equals(that.sessionTime) : that.sessionTime != null) return false;
		if (sessionsSinceLastWeek != null ? !sessionsSinceLastWeek.equals(that.sessionsSinceLastWeek) : that.sessionsSinceLastWeek != null)
			return false;
		if (sessionsToday != null ? !sessionsToday.equals(that.sessionsToday) : that.sessionsToday != null)
			return false;
		if (timeOnSiteSinceLastWeek != null ? !timeOnSiteSinceLastWeek.equals(that.timeOnSiteSinceLastWeek) : that.timeOnSiteSinceLastWeek != null)
			return false;
		if (timeOnSiteToday != null ? !timeOnSiteToday.equals(that.timeOnSiteToday) : that.timeOnSiteToday != null)
			return false;
		if (timePerPageSinceLastWeek != null ? !timePerPageSinceLastWeek.equals(that.timePerPageSinceLastWeek) : that.timePerPageSinceLastWeek != null)
			return false;
		if (timeSinceLastSale != null ? !timeSinceLastSale.equals(that.timeSinceLastSale) : that.timeSinceLastSale != null)
			return false;

		return true;
	}

	/* Getters and Setters */

	public Double getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Double sessionTime) {
		this.sessionTime = sessionTime;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public Double getTimeOnSiteToday() {
		return timeOnSiteToday;
	}

	public void setTimeOnSiteToday(Double timeOnSiteToday) {
		this.timeOnSiteToday = timeOnSiteToday;
	}

	public Integer getAccountsCreatedToday() {
		return accountsCreatedToday;
	}

	public void setAccountsCreatedToday(Integer accountsCreatedToday) {
		this.accountsCreatedToday = accountsCreatedToday;
	}

	public Integer getPasswordResetsToday() {
		return passwordResetsToday;
	}

	public void setPasswordResetsToday(Integer passwordResetsToday) {
		this.passwordResetsToday = passwordResetsToday;
	}

	public Integer getSalesDeclinedToday() {
		return salesDeclinedToday;
	}

	public void setSalesDeclinedToday(Integer salesDeclinedToday) {
		this.salesDeclinedToday = salesDeclinedToday;
	}

	public Integer getSessionsToday() {
		return sessionsToday;
	}

	public void setSessionsToday(Integer sessionsToday) {
		this.sessionsToday = sessionsToday;
	}

	public Double getTimeOnSiteSinceLastWeek() {
		return timeOnSiteSinceLastWeek;
	}

	public void setTimeOnSiteSinceLastWeek(Double timeOnSiteSinceLastWeek) {
		this.timeOnSiteSinceLastWeek = timeOnSiteSinceLastWeek;
	}

	public Integer getAccountsCreatedSinceLastWeek() {
		return accountsCreatedSinceLastWeek;
	}

	public void setAccountsCreatedSinceLastWeek(Integer accountsCreatedSinceLastWeek) {
		this.accountsCreatedSinceLastWeek = accountsCreatedSinceLastWeek;
	}

	public Double getTimePerPageSinceLastWeek() {
		return timePerPageSinceLastWeek;
	}

	public void setTimePerPageSinceLastWeek(Double timePerPageSinceLastWeek) {
		this.timePerPageSinceLastWeek = timePerPageSinceLastWeek;
	}

	public Integer getPasswordResetsSinceLastWeek() {
		return passwordResetsSinceLastWeek;
	}

	public void setPasswordResetsSinceLastWeek(Integer passwordResetsSinceLastWeek) {
		this.passwordResetsSinceLastWeek = passwordResetsSinceLastWeek;
	}

	public Integer getCheckoutPageViewsSinceLastWeek() {
		return checkoutPageViewsSinceLastWeek;
	}

	public void setCheckoutPageViewsSinceLastWeek(Integer checkoutPageViewsSinceLastWeek) {
		this.checkoutPageViewsSinceLastWeek = checkoutPageViewsSinceLastWeek;
	}

	public Integer getSalesDeclinedSinceLastWeek() {
		return salesDeclinedSinceLastWeek;
	}

	public void setSalesDeclinedSinceLastWeek(Integer salesDeclinedSinceLastWeek) {
		this.salesDeclinedSinceLastWeek = salesDeclinedSinceLastWeek;
	}

	public Integer getSessionsSinceLastWeek() {
		return sessionsSinceLastWeek;
	}

	public void setSessionsSinceLastWeek(Integer sessionsSinceLastWeek) {
		this.sessionsSinceLastWeek = sessionsSinceLastWeek;
	}

	public Double getTimeSinceLastSale() {
		return timeSinceLastSale;
	}

	public void setTimeSinceLastSale(Double timeSinceLastSale) {
		this.timeSinceLastSale = timeSinceLastSale;
	}
}