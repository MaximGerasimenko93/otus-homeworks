package com.mvger.otus.homework.solid.entity;

public enum Nominals {

    ONE_HUNDRED(100),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000),
    FIVE_THOUSAND(5000);

    private final int value;

    Nominals(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
