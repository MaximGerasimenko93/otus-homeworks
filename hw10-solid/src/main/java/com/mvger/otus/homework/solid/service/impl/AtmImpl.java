package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.*;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AtmImpl implements Atm {
    private NoteHolder noteHolder;
    private Balance balance;
    private Addable addable;
    private GiveOut giveOut;
    private Checker checker;

    @Override
    public void addSum() {
        addable.addNote(noteHolder.getNotes(), noteHolder);
    }

    @Override
    public long currentBalance() {
        return balance.showBalance(noteHolder);
    }

    @Override
    public List<Note> transact(int querySum) {
        return giveOut.giveOut(noteHolder, querySum);
    }

    @Override
    public List<Note> transactByMin(int querySum) {
        return giveOut.giveOutByMin(noteHolder, querySum);
    }

    @Override
    public void check(int querySum) throws CheckSumException, IsDividableException {
        long currentBalance = balance.showBalance(noteHolder);
        checker.checkSum(querySum, currentBalance);
        checker.isDividable(querySum);
    }
}
