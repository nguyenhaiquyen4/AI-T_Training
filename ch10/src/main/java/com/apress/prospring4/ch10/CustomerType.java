package com.apress.prospring4.ch10;

public enum CustomerType {
    INDIVIDUAL("I"), CORPORATE("C");
    private String code;

    private CustomerType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
