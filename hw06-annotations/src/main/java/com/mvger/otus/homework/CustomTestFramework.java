package com.mvger.otus.homework;

import com.mvger.otus.homework.annotation.After;
import com.mvger.otus.homework.annotation.Before;
import com.mvger.otus.homework.annotation.Test;

public class CustomTestFramework {

    private Example example;

    @Before
    public void init() {
        example = new Example();
    }

    @Test
    public void testDoubleText() {
        String test = "Тест";
        String result = example.doubleText(test);
        if (("Тест" + "\n" + "Тест").equals(result)) {
            System.out.println("testDoubleText() работает");
        } else {
            System.out.println("testDoubleText() не работает");
        }
    }

    @Test
    public void testWithException() {
        System.out.println("Работа с exceptions");
        throw new RuntimeException();
    }

    @Test
    public void testOddOrEvenTextLength() {
        String test = "Тест";
        boolean flag = example.oddOrEvenTextLength(test);
        System.out.println(flag);
    }

    @After
    public void afterTest() {
        System.out.println("After тест");
    }
}
