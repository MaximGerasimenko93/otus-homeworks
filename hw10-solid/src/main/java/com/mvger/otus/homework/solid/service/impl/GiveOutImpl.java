package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.Balance;
import com.mvger.otus.homework.solid.service.Checker;
import com.mvger.otus.homework.solid.service.ClientQuery;
import com.mvger.otus.homework.solid.service.GiveOut;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GiveOutImpl implements GiveOut {
    @Override
    public List<Note> giveOut(NoteHolder noteHolder, int querySum) {
        List<Note> notes = noteHolder.getNotes()
                .stream().filter(note -> note.getNominal().getValue() <= querySum)
                .collect(Collectors.toList());
        noteHolder.getNotes().removeAll(notes);
        return notes;
    }

    @Override
    public List<Note> giveOutByMin(NoteHolder noteHolder, int querySum) {
        List<Note> notesByMin = noteHolder.getNotes().stream()
                .sorted(Comparator.comparing(note -> note.getNominal().getValue()))
                .filter(note -> note.getNominal().getValue() <= querySum)
                .collect(Collectors.toList());
        return notesByMin;
    }
}
