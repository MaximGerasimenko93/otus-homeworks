package com.mvger.otus.homework;

import java.util.Objects;

public class Orange extends Fruit {
    private String kind;

    public Orange(String name, int weight, String kind) {
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
        if (!(o instanceof Orange)) return false;
        if (!super.equals(o)) return false;
        Orange orange = (Orange) o;
        return Objects.equals(kind, orange.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kind);
    }

    @Override
    public String toString() {
        return "Апельсин {" +
                "сорт = '" + kind + '\'' +
                '}';
    }
}
