package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.service.Checker;

public class CheckerImpl implements Checker {

    @Override
    public RuntimeException checkSum(int querySum, long balance) {
        if (balance < querySum) {
            return new RuntimeException("Запрашиваемая сумма превышает баланс");
        }
        return null;
    }

    @Override
    public RuntimeException isDividable(int querySum) {
        if (querySum % 100 != 0) {
            return new RuntimeException("Введите сумму, кратную 100");
        }
        return null;
    }
}
