package com.mvger.otus.homework.solid.service;

import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;

public interface Checker {

    void checkSum(int querySum, long balance) throws CheckSumException;
    void isDividable(int querySum) throws IsDividableException;
}
