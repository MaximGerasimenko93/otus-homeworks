package com.mvger.otus.homework.patterns.model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ObjectForMessage {

    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
