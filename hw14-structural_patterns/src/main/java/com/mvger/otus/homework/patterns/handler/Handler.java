package com.mvger.otus.homework.patterns.handler;

import com.mvger.otus.homework.patterns.listener.Listener;
import com.mvger.otus.homework.patterns.model.Message;

public interface Handler {

    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}
