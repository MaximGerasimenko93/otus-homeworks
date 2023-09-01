package com.mvger.otus.homework;

import com.google.common.base.Splitter;

public class HelloOtus {
    public static void main(String[] args) {
        String greetings = "Hello Otus";
        Iterable<String> splitGreetings = Splitter.on(" ")
                .split(greetings);

        System.out.println(splitGreetings);
    }
}
