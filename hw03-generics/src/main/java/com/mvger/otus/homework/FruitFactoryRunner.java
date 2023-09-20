package com.mvger.otus.homework;

import java.util.ArrayList;
import java.util.List;

public class FruitFactoryRunner {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        Apple apple1 = new Apple("Яблоко", 1, "Симиренко");
        Apple apple2 = new Apple("Яблоко", 2, "Гала");
        Apple apple3 = new Apple("Яблоко", 1, "Голден");

        Box<Apple> appleBox1 = new Box<>(apples);
        appleBox1.addFruit(new Apple( "Яблоко" , 1, "Антоновка"));
        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);
        appleBox1.addFruit(apple3);

        List<Orange> oranges = new ArrayList<>();
        Orange orange1 = new Orange("Апельсин", 2, "Балта");
        Orange orange2 = new Orange("Апельсин", 2, "Первенец");
        Orange orange3 = new Orange("Апельсин", 3, "Карвальял");

        Box<Orange> orangeBox1 = new Box<>(oranges);
        orangeBox1.addFruit(orange1);
        orangeBox1.addFruit(orange2);
        orangeBox1.addFruit(orange3);


        System.out.println(appleBox1.weight());
        System.out.println(orangeBox1.weight());
        System.out.println(appleBox1.compare(appleBox1, orangeBox1));
    }
}
