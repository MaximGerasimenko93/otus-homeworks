package com.mvger.otus.homework.solid.repository;

import com.mvger.otus.homework.solid.entity.Note;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class NoteHolder {

    private List<Note> notes = new ArrayList<>();
}
