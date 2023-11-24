package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.Balance;

import java.util.List;

public class BalanceImpl implements Balance {
    @Override
    public long showBalance(NoteHolder noteHolder) {
        return noteHolder.getNotes().stream()
                .mapToLong(note -> note.getNominal().getValue())
                .sum();
    }
}
