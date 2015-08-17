package com.qc.fi.model;

public enum Currency {
    //TODO: convert from excel to get a full list
    CNY("CNY", "人民币",6.0)
    ;
    private String code;
    private String name;
    private Double exchangeRate;

    Currency(String code, String name, Double exchangeRate) {
        this.code = code;
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }
}
