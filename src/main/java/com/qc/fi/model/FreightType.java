package com.qc.fi.model;

public enum FreightType {
    NORMAL("01", "普通货物")
    ;
    private String code;
    private String name;

    FreightType(String code, String name) {
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
