package com.qc.fi.model;

public enum PackageType {
    BULK_OR_NUDE("06", "散装或裸装"),
    NOT_BULK("08", "非散装"),
    NOT_NUDE("09", "非裸装");

    private String name;
    private String description;

    private PackageType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
