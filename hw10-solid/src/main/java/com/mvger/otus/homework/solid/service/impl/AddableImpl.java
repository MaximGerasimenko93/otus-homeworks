package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.Addable;

import java.util.List;

public class AddableImpl implements Addable {

    @Override
    public void addNote(List<Note> notes, NoteHolder noteHolder) {
        noteHolder.getNotes().addAll(notes);
    }
}
