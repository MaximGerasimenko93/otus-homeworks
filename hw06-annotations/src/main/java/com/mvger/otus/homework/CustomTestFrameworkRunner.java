package com.mvger.otus.homework;

import com.mvger.otus.homework.annotation.After;
import com.mvger.otus.homework.annotation.Before;
import com.mvger.otus.homework.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CustomTestFrameworkRunner {

    public static void main(String[] args) {
        runAllTests(CustomTestFramework.class);
    }

    private static Object createTestObject(Class<?> clazz) {
        return clazz.getConstructors();
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

    public static Method[] getMethodsWithAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationClass)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods.toArray(new Method[0]);
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
                    executeMethods(getMethodsWithAnnotation(clazz, Before.class), testObject);
                    testMethod.invoke(testObject);
                    executeMethods(getMethodsWithAnnotation(clazz, After.class), testObject);
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