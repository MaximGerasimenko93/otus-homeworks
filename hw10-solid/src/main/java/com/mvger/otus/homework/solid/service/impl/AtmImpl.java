package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.*;

import java.util.List;

public class AtmImpl implements Atm {
    private NoteHolder noteHolder;
    private ClientQuery clientQuery;
    private Balance balance;

    public AtmImpl(NoteHolder noteHolder, ClientQuery clientQuery, Balance balance) {
        this.noteHolder = noteHolder;
        this.clientQuery = clientQuery;
        this.balance = balance;
    }

    @Override
    public void addSum(AddableImpl addable) {
        addable.addNote(noteHolder.getNotes(), noteHolder);
    }

    @Override
    public long currentBalance(Balance balance) {
        return balance.showBalance(noteHolder);
    }

    @Override
    public List<Note> transact(GiveOut giveOut, int querySum) throws CheckSumException, IsDividableException {
        return giveOut.giveOut(noteHolder, querySum);
    }

    @Override
    public List<Note> transactByMin(GiveOut giveOut, int querySum) throws CheckSumException, IsDividableException {
        return giveOut.giveOutByMin(noteHolder, querySum);
    }

    @Override
    public void check(Checker checker, int querySum) throws CheckSumException, IsDividableException {
        long currentBalance = balance.showBalance(noteHolder);

        checker.checkSum(querySum, currentBalance);
        checker.isDividable(querySum);
    }
}
