package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.Addable;
import com.mvger.otus.homework.solid.service.Balance;
import com.mvger.otus.homework.solid.service.Checker;
import com.mvger.otus.homework.solid.service.GiveOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AtmImplTest {

    @Mock
    private Addable addable;

    @Mock
    private NoteHolder noteHolder;

    @Mock
    private Balance balance;

    @Mock
    GiveOut giveOut;

    @Mock
    Checker checker;

    @InjectMocks
    private AtmImpl atm;

    @Test
    void addSumTest() {
        when(noteHolder.getNotes()).thenReturn(new ArrayList<>());
        atm.addSum();
        verify(noteHolder, times(1)).getNotes();
    }

    @Test
    void currentBalanceTest() {
        when(balance.showBalance(noteHolder)).thenReturn(10L);
        long result = atm.currentBalance();
        assertEquals(10L, result);
    }

    @Test
    void transactTest() {
        when(giveOut.giveOut(noteHolder, 1000)).thenReturn(new ArrayList<>());
        List<Note> result = atm.transact(1000);
        assertEquals(result, new ArrayList<>());
    }

    @Test
    void transactByMinTest() {
        when(giveOut.giveOut(noteHolder, 1000)).thenReturn(new ArrayList<>());
        List<Note> result = atm.transact(1000);
        assertEquals(result, new ArrayList<>());
    }

    @Test
    void checkTest() throws IsDividableException, CheckSumException {
        int querySum = 2555;
        long currentBalance = 1000L;
        when(balance.showBalance(noteHolder)).thenReturn(currentBalance);
        assertDoesNotThrow(() -> atm.check(querySum));
        verify(checker).checkSum(eq(querySum), eq(currentBalance));
        verify(checker).isDividable(eq(querySum));
    }
}