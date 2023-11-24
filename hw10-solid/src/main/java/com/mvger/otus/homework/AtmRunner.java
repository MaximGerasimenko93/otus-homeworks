package com.mvger.otus.homework;

import com.mvger.otus.homework.solid.entity.Nominals;
import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.*;
import com.mvger.otus.homework.solid.service.impl.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtmRunner {
    public static void main(String[] args) {
        NoteHolder noteHolder = new NoteHolder();
        Addable addable = new AddableImpl();
        Balance balance = new BalanceImpl();
        GiveOut giveOut = new GiveOutImpl();
        ClientQuery clientQuery = new ClientQueryImpl();
        Checker checker = new CheckerImpl();

        Note note1 = new Note(Nominals.ONE_HUNDRED);
        Note note2 = new Note(Nominals.FIVE_HUNDRED);
        Note note3 = new Note(Nominals.ONE_THOUSAND);
        Note note4 = new Note(Nominals.FIVE_THOUSAND);

        List<Note> notesToAdd = new ArrayList<>();
        notesToAdd.add(note1);
        notesToAdd.add(note2);
        notesToAdd.add(note3);
        notesToAdd.add(note4);

        addable.addNote(notesToAdd, noteHolder);

        int querySum = clientQuery.readQuery();
        long showBalance = balance.showBalance(noteHolder);
        checker.checkSum(querySum, showBalance);
        checker.isDividable(querySum);

        System.out.println("Баланс " + showBalance);
        System.out.println("======================");

        List<Note> notes = giveOut.giveOut(noteHolder, querySum);
        for (Note note : notes) {
            System.out.println("Выдана купюра: " + note.getNominal().getValue());
        }
        System.out.println("======================");
        System.out.println("Баланс " + balance.showBalance(noteHolder));
    }
}

