package com.qc.fi.model;

public enum TransportType {
    //TODO: to be confirmed as it is different with interface
    WATER("01", "全程陆运"),
    LAND("02", "水陆联运/水运"),
    AIR("03", "空陆联运/空运"),
    EXPRESS("04", "快递")
    ;

    private String code;
    private String name;

    TransportType(String code, String name) {
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
