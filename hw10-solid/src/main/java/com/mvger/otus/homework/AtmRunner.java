package com.mvger.otus.homework;

import com.mvger.otus.homework.solid.entity.Nominals;
import com.mvger.otus.homework.solid.entity.Note;
import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import com.mvger.otus.homework.solid.repository.NoteHolder;
import com.mvger.otus.homework.solid.service.*;
import com.mvger.otus.homework.solid.service.impl.*;

import java.util.ArrayList;
import java.util.List;

public class AtmRunner {
    public static void main(String[] args) {
        NoteHolder noteHolder = new NoteHolder();
        Addable addable = new AddableImpl();
        Balance balance = new BalanceImpl();
        GiveOut giveOut = new GiveOutImpl();
        ClientQuery clientQuery = new ClientQueryImpl();
        Checker checker = new CheckerImpl();

        Note note100 = new Note(Nominals.ONE_HUNDRED);
        Note note500 = new Note(Nominals.FIVE_HUNDRED);
        Note note1000 = new Note(Nominals.ONE_THOUSAND);
        Note note5000 = new Note(Nominals.FIVE_THOUSAND);

        List<Note> notesToAdd = new ArrayList<>();
        notesToAdd.add(note100);
        notesToAdd.add(note500);
        notesToAdd.add(note1000);
        notesToAdd.add(note5000);

        addable.addNote(notesToAdd, noteHolder);

        long currentBalance = balance.showBalance(noteHolder);
        System.out.println("Баланс: " + currentBalance);

        Atm atm = new AtmImpl(noteHolder, balance, addable, giveOut, checker);

        try {
            int querySum = clientQuery.readQuery();
            atm.check(querySum);
            System.out.println("======================");
            List<Note> notes = atm.transact(querySum);
            for (Note note : notes) {
                System.out.println("Выдана купюра: " + note.getNominal().getValue());
            }
            System.out.println("======================");
            long remainingBalance = atm.currentBalance();
            System.out.println("Остаток: " + remainingBalance);
        } catch (CheckSumException | IsDividableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            int querySum = clientQuery.readQuery();
            atm.check(querySum);
            System.out.println("======================");
            List<Note> notes = atm.transactByMin(querySum);
            for (Note note : notes) {
                System.out.println("Выдана купюра: " + note.getNominal().getValue());
            }
            System.out.println("======================");
            long remainingBalance = atm.currentBalance();
            System.out.println("Остаток: " + remainingBalance);
        } catch (CheckSumException | IsDividableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

