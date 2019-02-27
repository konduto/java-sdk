package com.konduto.sdk;

public enum DateFormat {
    ISO_DATETIME("yyyy-MM-dd'T'HH:mm:ss'Z'") {
        @Override
        public String getRegex() {
            return "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
        }
    },
    ISO_DATETIME_NO_SECONDS("yyyy-MM-dd'T'HH:mm'Z'") {
        @Override
        public String getRegex() {
            return "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}Z";
        }
    },
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

    public String getFormat() {
        return format;
    }

    public abstract String getRegex();
}