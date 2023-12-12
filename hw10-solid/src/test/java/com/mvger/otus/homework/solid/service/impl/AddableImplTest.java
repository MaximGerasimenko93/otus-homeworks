package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Nominals;
import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.Addable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddableImplTest {

    @Test
    void addNoteTest() {
        Addable addable = new AddableImpl();
        NoteHolder noteHolder = new NoteHolder();
        Note note1 = new Note(Nominals.ONE_THOUSAND);
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        addable.addNote(notes, noteHolder);
        List<Note> storedNotes = noteHolder.getNotes();
        assertEquals(notes, storedNotes);
    }
}
