package com.mvger.otus.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// Банкноты должны как-то храниться.
@Getter
public class NoteHolder {
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    // TODO:
    //  Сделать интерфейсы:
    //  × класть деньги в хранилище
    //  x выдавать сумму остатка денежных средств
    //  выдавать запрошенную сумму минимальным количеством банкнот
    //  или ошибку если сумму нельзя выдать
    // Подумать, кто эти интерфейсы должен реализовывать.


    //  Смотреть книгу чистый код
}
