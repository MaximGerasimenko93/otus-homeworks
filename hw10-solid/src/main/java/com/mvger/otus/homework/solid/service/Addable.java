package com.mvger.otus.homework.solid.service;


import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;

import java.util.List;

public interface Addable {
    void addNote(List<Note> notes, NoteHolder noteHolder);
}
