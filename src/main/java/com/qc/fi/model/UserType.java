package com.qc.fi.model;

public enum UserType {
    ADMIN(1), NORMAL(2);

    private int code;
    UserType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
