package com.konduto.sdk;

/**
 * Enumeration of supported date formats for Konduto API.
 * Each format provides a regex pattern for validation.
 */
public enum DateFormat {
    /**
     * ISO 8601 datetime format with seconds: yyyy-MM-ddTHH:mm:ssZ
     */
    ISO_DATETIME("yyyy-MM-dd'T'HH:mm:ss'Z'") {
        @Override
        public String getRegex() {
            return "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
        }
    },
    /**
     * ISO 8601 datetime format without seconds: yyyy-MM-ddTHH:mmZ
     */
    ISO_DATETIME_NO_SECONDS("yyyy-MM-dd'T'HH:mm'Z'") {
        @Override
        public String getRegex() {
            return "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}Z";
        }
    },
    /**
     * Simple date format: yyyy-MM-dd
     */
    DATE("yyyy-MM-dd") {
        @Override
        public String getRegex() {
            return "\\d{4}-\\d{2}-\\d{2}";
        }
    };

    private String format;

    DateFormat(String format) {
        this.format = format;
    }

    /**
     * Gets the date format pattern.
     *
     * @return the format pattern string
     */
    public String getFormat() {
        return format;
    }

    /**
     * Gets the regex pattern for validating dates in this format.
     *
     * @return the regex pattern string
     */
    public abstract String getRegex();
}