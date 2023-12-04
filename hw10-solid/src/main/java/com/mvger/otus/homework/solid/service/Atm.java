package com.mvger.otus.homework.solid.service;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.service.impl.AddableImpl;

import java.util.List;

public interface Atm {
    void addSum(AddableImpl addable);
    long currentBalance(Balance balance);
    List<Note> transact(GiveOut giveOut, int querySum) throws CheckSumException, IsDividableException;
    List<Note> transactByMin(GiveOut giveOut, int querySum) throws CheckSumException, IsDividableException;
    void check(Checker checker, int querySum) throws CheckSumException, IsDividableException;
}
