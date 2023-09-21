package com.mvger.otus.homework;

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

    public boolean compare(Box<?> box) {
        return this.weight() > box.weight();
    }

    public void shuffleBox(Box<T> boxIn) {
        List<T> unboxingFruits = boxIn.getFruits();
        fruits.addAll(unboxingFruits);
    }

    public List<T> getFruits() {
        return fruits;
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
        return "Коробка {" +
                "фрукт = " + fruits +
                '}';
    }
}
