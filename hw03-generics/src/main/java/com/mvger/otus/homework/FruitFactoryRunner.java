package com.mvger.otus.homework;

import java.util.ArrayList;
import java.util.List;

public class FruitFactoryRunner {
    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        Apple apple1 = new Apple("Яблоко", 1, "Симиренко");
        Apple apple2 = new Apple("Яблоко", 2, "Гала");
        Apple apple3 = new Apple("Яблоко", 1, "Голден");

        Box<Apple> appleBox = new Box<>(apples);
        appleBox.addFruit(new Apple( "Яблоко" , 1, "Антоновка"));
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);
        appleBox.addFruit(apple3);

        List<Orange> oranges = new ArrayList<>();
        Orange orange1 = new Orange("Апельсин", 2, "Балта");
        Orange orange2 = new Orange("Апельсин", 2, "Первенец");
        Orange orange3 = new Orange("Апельсин", 3, "Карвальял");

        Box<Orange> orangeBox = new Box<>(oranges);
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);
        orangeBox.addFruit(orange3);

        List<Apple> applesForAnotherBox = new ArrayList<>();
        Box<Apple> emptyBoxForApples = new Box<>(applesForAnotherBox);
        emptyBoxForApples.shuffleBox(appleBox);

        List<Orange> orangesForAnotherBox = new ArrayList<>();
        Box<Orange> emptyBoxForOranges = new Box<>(orangesForAnotherBox);
        emptyBoxForOranges.shuffleBox(orangeBox);

        System.out.println("Вес коробки с яблоками: " + appleBox.weight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.weight());
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(emptyBoxForApples);
        System.out.println(emptyBoxForOranges);
    }
}
