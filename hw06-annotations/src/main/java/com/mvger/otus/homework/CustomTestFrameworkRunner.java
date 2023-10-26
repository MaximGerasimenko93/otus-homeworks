package com.mvger.otus.homework;

import com.mvger.otus.homework.annotation.After;
import com.mvger.otus.homework.annotation.Before;
import com.mvger.otus.homework.annotation.Test;

import java.lang.reflect.Method;

/**
 * 1. Get test file Class object
 * 2. runAllTests() uses reflection get method for all methods with annotations
 */

public class CustomTestFrameworkRunner {

    public static void main(String[] args) {
        runAllTests(CustomTestFramework.class);
    }

    private static Object createTestObject(Class<?> clazz) {
        return clazz.getClass().getConstructors();
    }

    private static void executeMethods(Method[] methods, Object object) {
        for (Method method : methods) {
            try {
                method.invoke(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void runAllTests(Class<?> clazz) {
        int totalTests = 0;
        int passedTests = 0;
        int failedTests = 0;

        for (Method testMethod : clazz.getDeclaredMethods()) {
            if (testMethod.isAnnotationPresent(Test.class)) {
                totalTests++;
                Object testObject = createTestObject(clazz);
                try {
                    executeMethods(clazz.getDeclaredAnnotationsByType(Before.class), testObject);
                    testMethod.invoke(testObject);
                    executeMethods(clazz.getDeclaredAnnotationsByType(After.class), testObject);
                    testMethod.invoke(testObject);
                    passedTests++;
                } catch (Exception e) {
                    failedTests++;
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Всего тестов: " + totalTests);
        System.out.println("Прошло тестов: " + passedTests);
        System.out.println("Упало тестов: " + failedTests);
    }
}