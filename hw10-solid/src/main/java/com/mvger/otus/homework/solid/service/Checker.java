package com.mvger.otus.homework.solid.service;

import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.impl.BalanceImpl;
import com.mvger.otus.homework.solid.service.impl.ClientQueryImpl;

public interface Checker {

    RuntimeException checkSum(int querySum, long balance);
    RuntimeException isDividable(int querySum);
}
