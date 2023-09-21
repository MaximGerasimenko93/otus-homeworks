package com.mvger.otus.homework;

import java.util.Objects;

public class Apple extends Fruit {

    private String kind;

    public Apple(String name, int weight, String kind) {
        super(name, weight);
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apple)) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return kind.equals(apple.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kind);
    }

    @Override
    public String toString() {
        return "Яблоко {" +
                "сорт = '" + kind + '\'' +
                '}';
    }
}
