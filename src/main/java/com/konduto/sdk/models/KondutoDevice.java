package com.konduto.sdk.models;

/**
 *
 * Device model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoDevice extends KondutoModel {
	private String userId;
	private String fingerprint;
	private String platform;
	private String browser;
	private String language;
	private String timezone;
	private boolean cookie;
	private boolean javascript;
	private boolean flash;
	private String ip;

	/**
	 * Default constructor.
	 */
	public KondutoDevice(){}

	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoDevice)) return false;

		KondutoDevice that = (KondutoDevice) o;

		if (cookie != that.cookie) return false;
		if (flash != that.flash) return false;
		if (javascript != that.javascript) return false;
		if (browser != null ? !browser.equals(that.browser) : that.browser != null) return false;
		if (fingerprint != null ? !fingerprint.equals(that.fingerprint) : that.fingerprint != null) return false;
		if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
		if (language != null ? !language.equals(that.language) : that.language != null) return false;
		if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
		if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;
		if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	/* Getters and Setters */

	/**
	 * Gets the user ID associated with the device.
	 *
	 * @return the user ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user ID associated with the device.
	 *
	 * @param userId the user ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the device fingerprint.
	 *
	 * @return the device fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}

	/**
	 * Sets the device fingerprint.
	 *
	 * @param fingerprint the device fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	/**
	 * Gets the device platform.
	 *
	 * @return the device platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * Sets the device platform.
	 *
	 * @param platform the device platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * Gets the device browser.
	 *
	 * @return the device browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * Sets the device browser.
	 *
	 * @param browser the device browser
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * Gets the device language.
	 *
	 * @return the device language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the device language.
	 *
	 * @param language the device language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the device timezone.
	 *
	 * @return the device timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * Sets the device timezone.
	 *
	 * @param timezone the device timezone
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * Checks if cookies are enabled on the device.
	 *
	 * @return true if cookies are enabled, false otherwise
	 */
	public boolean isCookieEnabled() {
		return cookie;
	}

	/**
	 * Sets whether cookies are enabled on the device.
	 *
	 * @param cookie true if cookies are enabled, false otherwise
	 */
	public void setCookie(boolean cookie) {
		this.cookie = cookie;
	}

	/**
	 * Checks if JavaScript is enabled on the device.
	 *
	 * @return true if JavaScript is enabled, false otherwise
	 */
	public boolean isJavascriptEnabled() {
		return javascript;
	}

	/**
	 * Sets whether JavaScript is enabled on the device.
	 *
	 * @param javascript true if JavaScript is enabled, false otherwise
	 */
	public void setJavascript(boolean javascript) {
		this.javascript = javascript;
	}

	/**
	 * Checks if Flash is enabled on the device.
	 *
	 * @return true if Flash is enabled, false otherwise
	 */
	public boolean isFlashEnabled() {
		return flash;
	}

	/**
	 * Sets whether Flash is enabled on the device.
	 *
	 * @param flash true if Flash is enabled, false otherwise
	 */
	public void setFlash(boolean flash) {
		this.flash = flash;
	}

	/**
	 * Gets the device's IP address.
	 *
	 * @return the device's IP address
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Sets the device's IP address.
	 *
	 * @param ip the device's IP address
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
}