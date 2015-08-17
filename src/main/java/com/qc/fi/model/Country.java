package com.qc.fi.model;

public enum Country {
    //TODO: convert from excel
    CHINA("01", "中国")
    ;
    private String code;
    private String name;

    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
