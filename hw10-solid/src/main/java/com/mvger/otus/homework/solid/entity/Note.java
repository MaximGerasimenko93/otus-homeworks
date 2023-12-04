package com.mvger.otus.homework.solid.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Note {

    private Nominals nominal;

    public Nominals getNominal() {
        return nominal;
    }
}
