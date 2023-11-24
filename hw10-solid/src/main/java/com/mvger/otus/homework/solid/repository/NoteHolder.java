package com.mvger.otus.homework.solid.repository;

import com.mvger.otus.homework.solid.entity.Note;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class NoteHolder {

    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }
}
