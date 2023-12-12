package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.service.Checker;

public class CheckerImpl implements Checker {

    @Override
    public void checkSum(int querySum, long balance) throws CheckSumException {
        if (balance < querySum) {
            throw new CheckSumException("Запрашиваемая сумма превышает баланс");
        }
    }

    @Override
    public void isDividable(int querySum) throws IsDividableException {
        if (querySum % 100 != 0) {
            throw new IsDividableException("Введите сумму, кратную 100");
        }
    }
}
