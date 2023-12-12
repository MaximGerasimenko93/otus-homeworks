package com.mvger.otus.homework.solid.service;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.service.impl.AddableImpl;

import java.util.List;

public interface Atm {
    void addSum();
    long currentBalance();
    List<Note> transact(int querySum) throws CheckSumException, IsDividableException;
    List<Note> transactByMin(int querySum) throws CheckSumException, IsDividableException;
    void check(int querySum) throws CheckSumException, IsDividableException;
}
