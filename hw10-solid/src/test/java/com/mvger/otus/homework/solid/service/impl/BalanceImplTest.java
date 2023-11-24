package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Nominals;
import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.impl.BalanceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BalanceImplTest {

    @Mock
    private NoteHolder noteHolder;

    @InjectMocks
    private BalanceImpl balance;

    @Test
    void showBalanceTest() {
        Note note1 = new Note(Nominals.ONE_THOUSAND);
        Note note2 = new Note(Nominals.FIVE_HUNDRED);
        List<Note> notes = Arrays.asList(note1, note2);

        when(noteHolder.getNotes()).thenReturn(notes);

        Long sumBalance = balance.showBalance(noteHolder);
        int value1 = note1.getNominal().getValue();
        int value2 = note2.getNominal().getValue();
        int expectedBalance = value1 + value2;
        assertEquals(expectedBalance, sumBalance);
    }
}
