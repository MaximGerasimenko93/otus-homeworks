package com.mvger.otus.homework;

public class AtmRunner {
    public static void main(String[] args) {
        NoteHolder noteHolder = new NoteHolder();

        Note note100 = new Note(Nominals.ONE_HUNDRED);
        Note note500 = new Note(Nominals.FIVE_HUNDRED);
        Note note1000 = new Note(Nominals.ONE_THOUSAND);
        Note note5000 = new Note(Nominals.FIVE_THOUSAND);

        noteHolder.addNote(note100);
        noteHolder.addNote(note100);
        noteHolder.addNote(note100);
        noteHolder.addNote(note500);
        noteHolder.addNote(note1000);
        noteHolder.addNote(note5000);


        for (Note note: noteHolder.getNotes()) {
            System.out.println("Номинал купюры: " + note.getNominal().getValue());
        }
    }
}
