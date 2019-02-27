package com.konduto.sdk;

public enum DateFormat {
    ISO_DATETIME("yyyy-MM-dd'T'HH:mm:ss'Z'"),
    ISO_DATETIME_NO_SECONDS("yyyy-MM-dd'T'HH:mm'Z'"),
    DATE("yyyy-MM-dd");

    private String format;

    DateFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

}
