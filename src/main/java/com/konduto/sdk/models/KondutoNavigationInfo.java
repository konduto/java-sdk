package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Represents navigation information in the Konduto system.
 * This class extends KondutoModel and contains navigation-related attributes such as session times and page views.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
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

	/**
	 * Gets the session time.
	 * @return the session time
	 */
	public Double getSessionTime() {
		return sessionTime;
	}

	/**
	 * Sets the session time.
	 * @param sessionTime the session time
	 */
	public void setSessionTime(Double sessionTime) {
		this.sessionTime = sessionTime;
	}

	/**
	 * Gets the referrer.
	 * @return the referrer
	 */
	public String getReferrer() {
		return referrer;
	}

	/**
	 * Sets the referrer.
	 * @param referrer the referrer
	 */
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	/**
	 * Gets the time on site today.
	 * @return the time on site today
	 */
	public Double getTimeOnSiteToday() {
		return timeOnSiteToday;
	}

	/**
	 * Sets the time on site today.
	 * @param timeOnSiteToday the time on site today
	 */
	public void setTimeOnSiteToday(Double timeOnSiteToday) {
		this.timeOnSiteToday = timeOnSiteToday;
	}

	/**
	 * Gets the accounts created today.
	 * @return the accounts created today
	 */
	public Integer getAccountsCreatedToday() {
		return accountsCreatedToday;
	}

	/**
	 * Sets the accounts created today.
	 * @param accountsCreatedToday the accounts created today
	 */
	public void setAccountsCreatedToday(Integer accountsCreatedToday) {
		this.accountsCreatedToday = accountsCreatedToday;
	}

	/**
	 * Gets the password resets today.
	 * @return the password resets today
	 */
	public Integer getPasswordResetsToday() {
		return passwordResetsToday;
	}

	/**
	 * Sets the password resets today.
	 * @param passwordResetsToday the password resets today
	 */
	public void setPasswordResetsToday(Integer passwordResetsToday) {
		this.passwordResetsToday = passwordResetsToday;
	}

	/**
	 * Gets the sales declined today.
	 * @return the sales declined today
	 */
	public Integer getSalesDeclinedToday() {
		return salesDeclinedToday;
	}

	public void setSalesDeclinedToday(Integer salesDeclinedToday) {
		this.salesDeclinedToday = salesDeclinedToday;
	}

	/**
	 * Gets the sessions today.
	 * @return the sessions today
	 */
	public Integer getSessionsToday() {
		return sessionsToday;
	}

	public void setSessionsToday(Integer sessionsToday) {
		this.sessionsToday = sessionsToday;
	}

	/**
	 * Gets the time on site since last week.
	 * @return the time on site since last week
	 */
	public Double getTimeOnSiteSinceLastWeek() {
		return timeOnSiteSinceLastWeek;
	}

	public void setTimeOnSiteSinceLastWeek(Double timeOnSiteSinceLastWeek) {
		this.timeOnSiteSinceLastWeek = timeOnSiteSinceLastWeek;
	}

	/**
	 * Gets the accounts created since last week.
	 * @return the accounts created since last week
	 */
	public Integer getAccountsCreatedSinceLastWeek() {
		return accountsCreatedSinceLastWeek;
	}

	public void setAccountsCreatedSinceLastWeek(Integer accountsCreatedSinceLastWeek) {
		this.accountsCreatedSinceLastWeek = accountsCreatedSinceLastWeek;
	}

	/**
	 * Gets the time per page since last week.
	 * @return the time per page since last week
	 */
	public Double getTimePerPageSinceLastWeek() {
		return timePerPageSinceLastWeek;
	}

	/**
	 * Sets the time per page since last week.
	 * @param timePerPageSinceLastWeek the time per page since last week
	 */
	public void setTimePerPageSinceLastWeek(Double timePerPageSinceLastWeek) {
		this.timePerPageSinceLastWeek = timePerPageSinceLastWeek;
	}

	/**
	 * Gets the password resets since last week.
	 * @return the password resets since last week
	 */
	public Integer getPasswordResetsSinceLastWeek() {
		return passwordResetsSinceLastWeek;
	}

	/**
	 * Sets the password resets since last week.
	 * @param passwordResetsSinceLastWeek the password resets since last week
	 */
	public void setPasswordResetsSinceLastWeek(Integer passwordResetsSinceLastWeek) {
		this.passwordResetsSinceLastWeek = passwordResetsSinceLastWeek;
	}

	/**
	 * Gets the checkout page views since last week.
	 * @return the checkout page views since last week
	 */
	public Integer getCheckoutPageViewsSinceLastWeek() {
		return checkoutPageViewsSinceLastWeek;
	}

	/**
	 * Sets the checkout page views since last week.
	 * @param checkoutPageViewsSinceLastWeek the checkout page views since last week
	 */
	public void setCheckoutPageViewsSinceLastWeek(Integer checkoutPageViewsSinceLastWeek) {
		this.checkoutPageViewsSinceLastWeek = checkoutPageViewsSinceLastWeek;
	}

	/**
	 * Gets the sales declined since last week.
	 * @return the sales declined since last week
	 */
	public Integer getSalesDeclinedSinceLastWeek() {
		return salesDeclinedSinceLastWeek;
	}

	/**
	 * Sets the sales declined since last week.
	 * @param salesDeclinedSinceLastWeek the sales declined since last week
	 */
	public void setSalesDeclinedSinceLastWeek(Integer salesDeclinedSinceLastWeek) {
		this.salesDeclinedSinceLastWeek = salesDeclinedSinceLastWeek;
	}

	/**
	 * Gets the sessions since last week.
	 * @return the sessions since last week
	 */
	public Integer getSessionsSinceLastWeek() {
		return sessionsSinceLastWeek;
	}

	/**
	 * Sets the sessions since last week.
	 * @param sessionsSinceLastWeek the sessions since last week
	 */
	public void setSessionsSinceLastWeek(Integer sessionsSinceLastWeek) {
		this.sessionsSinceLastWeek = sessionsSinceLastWeek;
	}

	/**
	 * Gets the time since last sale.
	 * @return the time since last sale
	 */
	public Double getTimeSinceLastSale() {
		return timeSinceLastSale;
	}

	/**
	 * Sets the time since last sale.
	 * @param timeSinceLastSale the time since last sale
	 */
	public void setTimeSinceLastSale(Double timeSinceLastSale) {
		this.timeSinceLastSale = timeSinceLastSale;
	}
}