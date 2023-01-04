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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
