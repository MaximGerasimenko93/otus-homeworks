package com.mvger.otus.homework.patterns.listener.forhw;

import com.mvger.otus.homework.patterns.listener.Listener;
import com.mvger.otus.homework.patterns.model.Message;

import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    @Override
    public void onUpdated(Message msg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        throw new UnsupportedOperationException();
    }
}
