package com.mvger.otus.homework.solid.service;

import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.impl.BalanceImpl;
import com.mvger.otus.homework.solid.service.impl.ClientQueryImpl;

public interface Checker {

    void checkSum(int querySum, long balance) throws CheckSumException;
    void isDividable(int querySum) throws IsDividableException;
}
