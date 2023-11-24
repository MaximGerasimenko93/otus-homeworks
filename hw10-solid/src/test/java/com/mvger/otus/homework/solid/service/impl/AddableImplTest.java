package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Nominals;
import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.impl.AddableImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddableImplTest {

    @Mock
    private NoteHolder noteHolder;
    @InjectMocks
    AddableImpl addable;

    @Test
    void addNoteTest() {
        Note note1 = new Note(Nominals.ONE_THOUSAND);
        List<Note> notes = new ArrayList<>();
        notes.add(note1);

        when(noteHolder.getNotes()).thenReturn(new ArrayList<>());
        addable.addNote(notes, noteHolder);
        verify(noteHolder).getNotes().addAll(notes);

        List<Note> storedNotes = noteHolder.getNotes();
        assertEquals(notes, storedNotes);
    }
}
