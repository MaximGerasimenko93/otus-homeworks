package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Nominals;
import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GiveOutImplTest {
    @Mock
    private NoteHolder noteHolder;

    @InjectMocks
    private GiveOutImpl giveOut;

    @Test
    void giveOutTest() {
        Note note1 = new Note(Nominals.ONE_THOUSAND);
        List<Note> notes = new ArrayList<>();
        notes.add(note1);

        when(noteHolder.getNotes()).thenReturn(notes);
        List<Note> result = giveOut.giveOut(noteHolder, 1000);
        assertEquals(Arrays.asList(note1), result);
    }

    @Test
    void giveOutByMinTest() {
        Note note1 = new Note(Nominals.ONE_THOUSAND);
        Note note2 = new Note(Nominals.ONE_THOUSAND);
        Note note3 = new Note(Nominals.FIVE_HUNDRED);
        Note note4 = new Note(Nominals.ONE_HUNDRED);
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);

        when(noteHolder.getNotes()).thenReturn(notes);
        List<Note> sortedNotes = notes.stream()
                .sorted(Comparator.comparing(note -> note.getNominal().getValue()))
                .toList();
        List<Note> result = giveOut.giveOutByMin(noteHolder, 1000);

        assertEquals(sortedNotes, result);
    }
}