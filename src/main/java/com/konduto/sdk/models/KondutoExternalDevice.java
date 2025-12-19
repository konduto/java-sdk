package com.konduto.sdk.models;

/**
 *
 * External Device model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoExternalDevice extends KondutoModel {
    private String fingerprint;
    private String provider;
    private String category;
    private String model;
    private String platform;
    private String manufacturer;
    private String os;
    private String browser;
    private String language;

    /**
     * Default constructor.
     */
    public KondutoExternalDevice(){}

    /* Equals */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KondutoExternalDevice)) return false;

        KondutoExternalDevice that = (KondutoExternalDevice) o;

        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (os != null ? !os.equals(that.os) : that.os != null) return false;
        if (browser != null ? !browser.equals(that.browser) : that.browser != null) return false;
        if (fingerprint != null ? !fingerprint.equals(that.fingerprint) : that.fingerprint != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /* Getters and Setters */

    /**
     * Gets the fingerprint.
     * @return the fingerprint
     */
    public String getFingerprint() {
        return fingerprint;
    }

    /**
     * Sets the fingerprint.
     * @param fingerprint the fingerprint
     */
    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    /**
     * Gets the platform.
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform.
     * @param platform the platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Gets the browser.
     * @return the browser
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Sets the browser.
     * @param browser the browser
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    /**
     * Gets the language.
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the provider.
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Sets the provider.
     * @param provider the provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * Gets the category.
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the model.
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model.
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the manufacturer.
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer.
     * @param manufacturer the manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the OS.
     * @return the OS
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the OS.
     * @param os the OS
     */
    public void setOs(String os) {
        this.os = os;
    }
}
