package com.mvger.otus.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T extends Fruit> {

    private List<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public int weight() {
        int result = 0;
        for (T fruit : fruits) {
            result = result + fruit.getWeight();
        }
        return result;
    }

    public boolean compare(Box<?> box1, Box<?> box2) {
        return box1.weight() > box2.weight();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public void setFruits(List<T> fruits) {
        this.fruits = fruits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box<?> box = (Box<?>) o;
        return fruits.equals(box.fruits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruits);
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
