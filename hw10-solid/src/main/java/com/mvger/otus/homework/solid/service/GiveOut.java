package com.mvger.otus.homework.solid.service;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;

import java.util.List;

public interface GiveOut {

    List<Note> giveOut(NoteHolder noteHolder, int querySum);
    List<Note> giveOutByMin(NoteHolder noteHolder, int querySum);
}
