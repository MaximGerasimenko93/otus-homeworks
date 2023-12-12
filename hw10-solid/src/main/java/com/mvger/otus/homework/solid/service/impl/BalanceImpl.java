package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.Balance;

public class BalanceImpl implements Balance {
    @Override
    public long showBalance(NoteHolder noteHolder) {
        return noteHolder.getNotes().stream()
                .mapToLong(note -> note.getNominal().getValue())
                .sum();
    }
}
