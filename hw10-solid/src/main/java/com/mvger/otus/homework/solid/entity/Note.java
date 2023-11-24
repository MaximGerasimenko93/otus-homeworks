package com.mvger.otus.homework.solid.entity;

import com.mvger.otus.homework.solid.entity.Nominals;

public class Note {

    private Nominals nominal;

    public Note(Nominals nominal) {
        this.nominal = nominal;
    }

    public Nominals getNominal() {
        return nominal;
    }
}
