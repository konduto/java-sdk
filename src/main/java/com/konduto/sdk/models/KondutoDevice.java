package com.konduto.sdk.models;

/**
 * Created by rsampaio on 08/08/14.
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
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public boolean isCookieEnabled() {
		return cookie;
	}

	public void setCookie(boolean cookie) {
		this.cookie = cookie;
	}

	public boolean isJavascriptEnabled() {
		return javascript;
	}

	public void setJavascript(boolean javascript) {
		this.javascript = javascript;
	}

	public boolean isFlashEnabled() {
		return flash;
	}

	public void setFlash(boolean flash) {
		this.flash = flash;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}